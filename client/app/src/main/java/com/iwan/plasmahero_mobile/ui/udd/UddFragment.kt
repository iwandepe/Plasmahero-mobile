package com.iwan.plasmahero_mobile.ui.udd

import android.Manifest
import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import com.iwan.plasmahero_mobile.R
import com.iwan.plasmahero_mobile.ui.udd.dummy.DummyContent
import android.content.Intent
import android.content.pm.PackageManager
import android.location.Location
import android.net.Uri
import android.util.Log
import android.widget.TextView
import android.widget.Toast
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import com.google.android.gms.tasks.OnCompleteListener
import com.google.android.gms.tasks.Task
import com.iwan.plasmahero_mobile.MainActivity

import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationServices
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import com.iwan.plasmahero_mobile.data.model.UddModel
import kotlin.math.*

class UddFragment : Fragment() {

    private var columnCount = 1
    private var locationPermissionGranted : Boolean = false
    private var lastKnownLocation: Location? = null
    private var closestUdd : UddModel.UddValue? = null
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
                CameraUpdateFactory.newLatLngZoom( defaultLocation, 15F)
            )

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

                gMap!!.addMarker(MarkerOptions().position(LatLng(closestUdd!!.lat!!, closestUdd!!.lng!!)))
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

    private fun getClosestUdd(lat: Double, lng:Double) : UddModel.UddValue? {
        val uddList = UddModel.getUddList()
        val curLat = lastKnownLocation!!.latitude
        val curLng = lastKnownLocation!!.longitude
        var closestUdd : UddModel.UddValue? = null
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
}