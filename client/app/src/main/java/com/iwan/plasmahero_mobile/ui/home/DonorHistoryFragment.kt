package com.iwan.plasmahero_mobile.ui.home

import android.os.Build
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.iwan.plasmahero_mobile.R
import com.iwan.plasmahero_mobile.data.source.remote.RemoteDataSource
import com.iwan.plasmahero_mobile.data.source.remote.responses.DonorHistoryResponse
import com.iwan.plasmahero_mobile.data.source.remote.responses.HistoryData
import com.iwan.plasmahero_mobile.data.source.remote.responses.ProfileResponse
import com.iwan.plasmahero_mobile.utils.SessionManager
import com.iwan.plasmahero_mobile.utils.SessionManager.token
import com.iwan.plasmahero_mobile.utils.SessionManager.userId
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.time.LocalDate
import java.time.format.DateTimeFormatter

class DonorHistoryFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_donor_history, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        var data: MutableList<HistoryData> = mutableListOf()

        val historyItemAdapter = HistoryItemAdapter(data, R.layout.fragment_donor_history_item)
        val rvHistoryDonor = view.findViewById<RecyclerView>(R.id.rvHistoryDonor)
        rvHistoryDonor.adapter = historyItemAdapter

        val prefs = SessionManager.getSharedPreferences(requireActivity())
        val token = "Bearer " + prefs.token
        val userId = prefs.userId
        val call = RemoteDataSource.getDonorHistoryById(userId, token.toString())
        call.enqueue(object : Callback<DonorHistoryResponse> {
            @RequiresApi(Build.VERSION_CODES.O)
            override fun onResponse(call: Call<DonorHistoryResponse>, response: Response<DonorHistoryResponse>) {
                Log.d("Response", response.toString())
                if (response.body()?.success == true) {
                    Log.v("Response success", response.body().toString())

                    data.addAll(response.body()!!.data!!.filterNotNull())

                    if (data != null) {
                        println("Dataset isnt null")
                        historyItemAdapter.notifyDataSetChanged()
                    }
                } else {
                    Log.v("Response failed", response.body().toString())
                    Toast.makeText(requireContext(), "Gagal mendapat data", Toast.LENGTH_SHORT).show()
                }
            }

            override fun onFailure(call: Call<DonorHistoryResponse>, t: Throwable) {
                Log.v("Response", "Get Profile Unsuccessfull")
                Log.v("Response", t.message.toString())
                Toast.makeText(requireContext(), "Terjadi error saat meminta data", Toast.LENGTH_SHORT).show()
            }
        })
    }

    class HistoryItemAdapter(
        private val data: MutableList<HistoryData>,
        private val rowLayout: Int
    ) : RecyclerView.Adapter<HistoryItemAdapter.ViewHolder>() {
        class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
            val udd: TextView
            val date: TextView

            init {
                udd = view.findViewById(R.id.tvHistoryUdd)
                date = view.findViewById(R.id.tvHistoryDate)
            }
        }

        override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
            val view = LayoutInflater.from(viewGroup.context)
                .inflate(rowLayout, viewGroup, false)

            return ViewHolder(view)
        }

        override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {

            viewHolder.udd.text = data[position].udd.toString()
            viewHolder.date.text = data[position].donorDate.toString()
        }

        override fun getItemCount() = data.size

    }
}