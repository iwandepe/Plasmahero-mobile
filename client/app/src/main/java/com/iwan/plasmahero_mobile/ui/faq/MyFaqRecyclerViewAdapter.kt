package com.iwan.plasmahero_mobile.ui.faq

import android.util.Log
import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.iwan.plasmahero_mobile.R
import com.iwan.plasmahero_mobile.data.model.FaqModel
import com.iwan.plasmahero_mobile.data.source.remote.RemoteDataSource
import com.iwan.plasmahero_mobile.data.source.remote.responses.FaqResponse
import retrofit2.Response

class MyFaqRecyclerViewAdapter(
        private var values: ArrayList<FaqResponse>)
    : RecyclerView.Adapter<MyFaqRecyclerViewAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
                .inflate(R.layout.fragment_item_faq, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = values[position]
        holder.tvQuestion.text = item.question
        holder.tvAnswer.text = item.answer
    }

    override fun getItemCount(): Int = values.size

    public fun fetchFaqData() {
        val call = RemoteDataSource.getFaq()
        var faqList: ArrayList<FaqResponse> = ArrayList()

        call.enqueue(
            object : retrofit2.Callback<List<FaqResponse>> {

                override fun onFailure(call: retrofit2.Call<List<FaqResponse>>?, t: Throwable?) {
                    Log.e("getFaqs() Failure", t.toString())
                }

                override fun onResponse(
                    call: retrofit2.Call<List<FaqResponse>>?,
                    response: Response<List<FaqResponse>>?
                ) {
                    if (response?.isSuccessful == true) {
                        val rs: List<FaqResponse>? = response.body()
                        faqList = ArrayList(rs)
                        values = faqList
                        notifyDataSetChanged()
//                        Log.e("ALIST", faqList.toString())

                    }
                }
            }
        )
    }

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val tvQuestion: TextView = view.findViewById(R.id.tvQuestion)
        val tvAnswer: TextView = view.findViewById(R.id.tvAnswer)

        override fun toString(): String {
            return super.toString() + " '" + tvQuestion.text + "'"
        }
    }
}