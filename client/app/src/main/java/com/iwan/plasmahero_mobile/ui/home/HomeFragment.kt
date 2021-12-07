package com.iwan.plasmahero_mobile.ui.home

import android.app.Activity
import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.google.android.material.card.MaterialCardView
import com.iwan.plasmahero_mobile.LoginActivity
import com.iwan.plasmahero_mobile.R
import com.iwan.plasmahero_mobile.data.source.remote.RemoteDataSource
import com.iwan.plasmahero_mobile.data.source.remote.responses.ProfileResponse
import com.iwan.plasmahero_mobile.utils.SessionManager
import com.iwan.plasmahero_mobile.utils.SessionManager.token
import com.iwan.plasmahero_mobile.utils.SessionManager.userId
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.time.LocalDate
import java.time.format.DateTimeFormatter

class HomeFragment : Fragment() {

    private lateinit var homeViewModel: HomeViewModel

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        homeViewModel =
                ViewModelProvider(this).get(HomeViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_home, container, false)
        val textView: TextView = root.findViewById(R.id.text_home)
        homeViewModel.text.observe(viewLifecycleOwner, Observer {
            textView.text = it
        })
        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val tvProfileName = view.findViewById<TextView>(R.id.tvProfileName)
        val tvProfileType = view.findViewById<TextView>(R.id.tvProfileType)
        val tvProfileDonorTotal = view.findViewById<TextView>(R.id.tvProfileDonorTotal)
        val tvProfileDonorLast = view.findViewById<TextView>(R.id.tvProfileDonorLast)
        val tvProfileDonorAgain = view.findViewById<TextView>(R.id.tvProfileDonorAgain)

        val btnLogout = view.findViewById<Button>(R.id.btnLogout)
        val mcvHomeDonorHistory = view.findViewById<MaterialCardView>(R.id.mcvHomeDonorHistory)
        val mcvHomeAboutPlasma = view.findViewById<MaterialCardView>(R.id.mcvHomeAboutPlasma)

        mcvHomeAboutPlasma.setOnClickListener {
            val navController = findNavController()
            navController.navigate(R.id.action_navigation_home_to_navigation_about_plasma)
        }

        val prefs = SessionManager.getSharedPreferences(requireActivity())
        val token = "Bearer " + prefs.token
        val userId = prefs.userId
        val call = RemoteDataSource.getProfileById(userId, token.toString())
        call.enqueue(object : Callback<ProfileResponse> {
            @RequiresApi(Build.VERSION_CODES.O)
            override fun onResponse(call: Call<ProfileResponse>, response: Response<ProfileResponse>) {
                Log.d("Response", response.toString())
                if (response.body()?.success == true) {
                    Log.v("Response success", response.body().toString())

                    tvProfileName.text = response.body()?.data?.name
                    tvProfileDonorTotal.text = response.body()?.data?.history!!.size.toString()

                    if (response.body()?.data?.type == "donor")
                        tvProfileType.text = getString(R.string.text_donor_role)
                    else
                        tvProfileType.text = getString(R.string.text_recipient_role)

                    val dateFormat = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")
                    val donorDate = LocalDate.parse(response.body()?.data?.history!![0].donorDate, dateFormat)

                    tvProfileDonorLast.text = donorDate.dayOfMonth.toString() + " " + donorDate.month.toString() + " " + donorDate.year.toString();
                    tvProfileDonorAgain.text = donorDate.dayOfMonth.toString() + " " + (donorDate.month + 3).toString() + " " + donorDate.year.toString();
                } else {
                    Log.v("Response failed", response.body().toString())
                    Toast.makeText(requireContext(), "Gagal mendapat data", Toast.LENGTH_SHORT).show()
                }
            }

            override fun onFailure(call: Call<ProfileResponse>, t: Throwable) {
                Log.v("Response", "Get Profile Unsuccessfull")
                Log.v("Response", t.message.toString())
                Toast.makeText(requireContext(), "Terjadi error saat meminta data", Toast.LENGTH_SHORT).show()
            }
        })

        btnLogout.setOnClickListener {
            val prefs = SessionManager.getSharedPreferences(requireActivity())
            prefs.edit().clear().commit()

            requireActivity().setResult(Activity.RESULT_OK)
            requireActivity().finish()

            val intent = Intent(activity, LoginActivity::class.java)
            startActivity(intent)
        }
    }
}