package com.iwan.plasmahero_mobile.data.model

import android.util.Log
import com.iwan.plasmahero_mobile.network.ApiClient
import retrofit2.Response
import java.util.*
import com.google.gson.annotations.SerializedName
import com.google.gson.annotations.Expose
import kotlin.collections.ArrayList


object UddModel {
    private var uddList : ArrayList<UddValue> = ArrayList()

    fun getUddList(): ArrayList<UddValue>{
        uddList.add(UddValue("UDDP",	-6.3186859,106.8345763))
        uddList.add(UddValue("UDD PMI DKI",	-6.1849241,106.8424645))
        uddList.add(UddValue("UDD PMI Kota Banda Aceh",	5.5654618,95.3400146))
        uddList.add(UddValue("UDD PMI Kota Medan",	3.5993858,98.6835343))
        uddList.add(UddValue("UDD PMI Pekanbaru",	0.5190611,101.4560193))
        uddList.add(UddValue("UDD PMI Cilacap",	-7.6806311,108.9103799))
        uddList.add(UddValue("UDD PMI Surabaya",	-7.2681377,112.7371342))
        uddList.add(UddValue("UDD PMI Kota Malang",	-7.9722669,112.6253048))
        uddList.add(UddValue("UDD PMI Sidoarjo",	-7.4459834,112.6943168))
        uddList.add(UddValue("UDD PMI Kab. Jember",	-8.1405127,113.7179428))

        return uddList
    }

//    fun fetchEventData() : ArrayList<EventValue>{
//        val call = ApiClient().instance().getEvents()
//
//        call.enqueue(
//            object : retrofit2.Callback<List<EventValue>>{
//
//                override fun onFailure(call: retrofit2.Call<List<EventValue>>?, t: Throwable?) {
//                    Log.e("getEvents() Failure", t.toString())
//                }
//
//                override fun onResponse(call: retrofit2.Call<List<EventValue>>?, response: Response<List<EventValue>>?) {
//                    if(response?.isSuccessful == true){
//                        val rs: List<EventValue>? = response.body()
//                        eventList = ArrayList(rs)
//
//                    }
//                }
//            }
//        )
//
//        return eventList
//    }

    class UddValue {
        var name: String? = null

        var lat: Double? = null

        var lng: Double? = null

        constructor(name: String, lat:Double, lng:Double){
            this.name = name
            this.lat = lat
            this.lng = lng
        }

    }
}


