package com.iwan.plasmahero_mobile.data.model

import android.util.Log
import com.iwan.plasmahero_mobile.network.ApiClient
import retrofit2.Response
import java.util.*
import com.google.gson.annotations.SerializedName
import com.google.gson.annotations.Expose
import kotlin.collections.ArrayList


object EventModel {
    var eventList : ArrayList<EventValue> = ArrayList()

    fun fetchEventData() : ArrayList<EventValue>{
        val call = ApiClient().instance().getEvents()

        call.enqueue(
            object : retrofit2.Callback<List<EventValue>>{

                override fun onFailure(call: retrofit2.Call<List<EventValue>>?, t: Throwable?) {
                    Log.e("getEvents() Failure", t.toString())
                }

                override fun onResponse(call: retrofit2.Call<List<EventValue>>?, response: Response<List<EventValue>>?) {
                    if(response?.isSuccessful == true){
                        val rs: List<EventValue>? = response.body()
                        eventList = ArrayList(rs)

                    }
                }
            }
        )

        return eventList
    }

    class EventValue {
        @SerializedName("title")
        @Expose
        var title: String? = null

        @SerializedName("date")
        @Expose
        var date: String? = null

        @SerializedName("desc")
        @Expose
        var desc: String? = null

        @SerializedName("imgUrl")
        @Expose
        var imgUrl: String? = null

    }
}


