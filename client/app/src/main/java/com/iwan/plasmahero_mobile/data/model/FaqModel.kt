package com.iwan.plasmahero_mobile.data.model

import android.util.Log
import com.iwan.plasmahero_mobile.network.ApiClient
import retrofit2.Response
import java.util.*
import com.google.gson.annotations.SerializedName
import com.google.gson.annotations.Expose
import kotlin.collections.ArrayList


object FaqModel {
    var faqList : ArrayList<FaqValue> = ArrayList()

    fun fetchFaqData() : ArrayList<FaqValue>{
        val call = ApiClient().instance().getFaqs()

        call.enqueue(
            object : retrofit2.Callback<List<FaqValue>>{

                override fun onFailure(call: retrofit2.Call<List<FaqValue>>?, t: Throwable?) {
                    Log.e("getFaqs() Failure", t.toString())
                }

                override fun onResponse(call: retrofit2.Call<List<FaqValue>>?, response: Response<List<FaqValue>>?) {
                    if(response?.isSuccessful == true){
                        val rs: List<FaqValue>? = response.body()
                        faqList = ArrayList(rs)

                    }
                }
            }
        )

        return faqList
    }

    class FaqValue {
        @SerializedName("q")
        @Expose
        var question: String? = null

        @SerializedName("a")
        @Expose
        var answer: String? = null

    }
}


