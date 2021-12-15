package com.iwan.plasmahero_mobile.ui.udd

import android.Manifest
import android.annotation.SuppressLint
import android.content.Intent
import android.content.pm.PackageManager
import android.location.Location
import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationServices
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import com.google.android.gms.tasks.OnCompleteListener
import com.google.android.gms.tasks.Task
import com.iwan.plasmahero_mobile.R
import com.iwan.plasmahero_mobile.data.source.remote.responses.UddValue
import com.iwan.plasmahero_mobile.ui.udd.dummy.DummyContent
import kotlin.math.*

class UddFragment : Fragment() {

    private var columnCount = 1
    private var locationPermissionGranted : Boolean = false
    private var lastKnownLocation: Location? = null
    private var closestUdd : UddValue? = null
    private var gMap: GoogleMap? = null
    private val defaultLocation = LatLng(-7.28, 112.79)


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        arguments?.let {
            columnCount = it.getInt(ARG_COLUMN_COUNT)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_udd, container, false)
        val btnUdd : Button = view.findViewById(R.id.btnUdd)
        val btnOpenMaps : Button = view.findViewById(R.id.btnOpenMaps)
        val tvUddName : TextView = view.findViewById(R.id.tvUddName)
        val tvUddAddress : TextView = view.findViewById(R.id.tvUddAddress)

        val mapFragment : SupportMapFragment = childFragmentManager.findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync {
            Toast.makeText(requireContext(), "On Map Ready", Toast.LENGTH_SHORT).show()

            gMap = it
            gMap!!.animateCamera(
                CameraUpdateFactory.newLatLngZoom( defaultLocation, 5F)
            )

            val uddList = getUddList()
            for (udd in uddList)
                gMap!!.addMarker(MarkerOptions().position(LatLng(udd.lat!!, udd.lng!!)).title(udd.name))!!.showInfoWindow()
        }

        btnOpenMaps.setOnClickListener{
            var uriStr : String? = null
            if(closestUdd !=null) {
                uriStr = "geo:"+closestUdd!!.lat.toString()+","+closestUdd!!.lng.toString()+"?q=" + Uri.encode(closestUdd!!.name)
            }else{
                uriStr = "geo:"+defaultLocation!!.latitude.toString()+","+defaultLocation!!.longitude.toString()+"?q=" + Uri.encode("PMI")
            }

            val gmmIntentUri = Uri.parse(uriStr)
            val mapIntent = Intent(Intent.ACTION_VIEW, gmmIntentUri)
            mapIntent.setPackage("com.google.android.apps.maps")
            startActivity(mapIntent)
        }

        btnUdd.setOnClickListener{
            getDeviceLocation()
            if(lastKnownLocation != null){
                closestUdd = getClosestUdd(lastKnownLocation!!.latitude, lastKnownLocation!!.longitude)
                val d = calcDistanceInKm(lastKnownLocation!!.latitude, lastKnownLocation!!.longitude, closestUdd!!.lat!!, closestUdd!!.lng!!)

//                gMap!!.addMarker(MarkerOptions().position(LatLng(closestUdd!!.lat!!, closestUdd!!.lng!!)))
                gMap!!.animateCamera(
                    CameraUpdateFactory.newLatLngZoom( LatLng(closestUdd!!.lat!!, closestUdd!!.lng!!),15F )
                )

                tvUddName.text = closestUdd!!.name
//                tvUddAddress.text = closestUdd!!.address
                Toast.makeText(requireContext(), closestUdd!!.name + ": ${d.toString()} Km", Toast.LENGTH_LONG).show()
            }

        }

        // Set the adapter
        if (view is RecyclerView) {
            with(view) {
                layoutManager = when {
                    columnCount <= 1 -> LinearLayoutManager(context)
                    else -> GridLayoutManager(context, columnCount)
                }
                adapter = MyUddRecyclerViewAdapter(DummyContent.ITEMS)
            }
        }
        return view
    }

    companion object {

        // TODO: Customize parameter argument names
        const val ARG_COLUMN_COUNT = "column-count"

        // TODO: Customize parameter initialization
        @JvmStatic
        fun newInstance(columnCount: Int) =
            UddFragment().apply {
                arguments = Bundle().apply {
                    putInt(ARG_COLUMN_COUNT, columnCount)
                }
            }
    }

    @SuppressLint("MissingPermission")
    private fun getDeviceLocation() {
        try {
            if (locationPermissionGranted) {
                var fusedLocationProviderClient: FusedLocationProviderClient? = LocationServices.getFusedLocationProviderClient(requireContext())

                val locationResult: Task<Location> = fusedLocationProviderClient!!.lastLocation

                locationResult.addOnCompleteListener(requireActivity(),
                    OnCompleteListener<Location?> { task ->
                        if (task.isSuccessful) {
                            lastKnownLocation = task.result
                        }
                        else{
                            Log.e("TASK", task.exception.toString())
                        }
                    })
            } else {
                Toast.makeText(requireContext(), "Permission Needed", Toast.LENGTH_SHORT).show()
                getLocationPermission()
            }
        } catch (e: SecurityException) {
            Log.e("Exception: %s", e.message, e)
        }
    }

    private fun getLocationPermission() {
        if (ContextCompat.checkSelfPermission(
                requireContext(),
                Manifest.permission.ACCESS_FINE_LOCATION
            )
            == PackageManager.PERMISSION_GRANTED
        ) {
            locationPermissionGranted = true
            Toast.makeText(requireContext(), "Permission GRANTED", Toast.LENGTH_SHORT).show()

        } else {
            ActivityCompat.requestPermissions(
                requireActivity(), arrayOf(Manifest.permission.ACCESS_FINE_LOCATION),
                99
            )
            getLocationPermission()
        }
        getDeviceLocation()
    }

    private fun getClosestUdd(lat: Double, lng:Double) : UddValue? {
        val uddList = getUddList()
        val curLat = lastKnownLocation!!.latitude
        val curLng = lastKnownLocation!!.longitude
        var closestUdd : UddValue? = null
        var distance = 99999

        uddList.forEach {
            val d = calcDistanceInKm(curLat, curLng, it.lat!!, it.lng!!)
            if(d < distance){
                distance = d
                closestUdd = it
            }
        }

        return closestUdd
    }

    private val AVERAGE_RADIUS_OF_EARTH_KM = 6371.0
    fun calcDistanceInKm( userLat: Double, userLng: Double, venueLat: Double, venueLng: Double ): Int {
        val latDistance = Math.toRadians(userLat - venueLat)
        val lngDistance = Math.toRadians(userLng - venueLng)

        val a = (sin(latDistance / 2) * sin(latDistance / 2)
                + (cos(Math.toRadians(userLat)) * cos(Math.toRadians(venueLat))
                * sin(lngDistance / 2) * sin(lngDistance / 2)))
        val c = 2 * atan2(sqrt(a), sqrt(1 - a))

        return (AVERAGE_RADIUS_OF_EARTH_KM * c).roundToInt().toInt()
    }

    fun getUddList(): ArrayList<UddValue>{
        val uddList : ArrayList<UddValue> = ArrayList()

        uddList.add(UddValue("UDDP", -6.3186859, 106.8345763))
        uddList.add(UddValue("UDD PMI DKI", -6.1849241, 106.8424645))
        uddList.add(UddValue("UDD PMI Kota Banda Aceh", 5.5654618, 95.3400146))
        uddList.add(UddValue("UDD PMI Kota Medan", 3.5993858, 98.6835343))
        uddList.add(UddValue("UDD PMI Pekanbaru", 0.5190611, 101.4560193))
        uddList.add(UddValue("UDD PMI Cilacap", -7.6806311, 108.9103799))
        uddList.add(UddValue("UDD PMI Surabaya", -7.2681377, 112.7371342))
        uddList.add(UddValue("UDD PMI Kota Malang", -7.9722669, 112.6253048))
        uddList.add(UddValue("UDD PMI Sidoarjo", -7.4459834, 112.6943168))
        uddList.add(UddValue("UDD PMI Kab. Jember", -8.1405127, 113.7179428))

        return uddList
    }
}