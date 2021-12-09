package com.iwan.plasmahero_mobile.ui.event

import android.content.Context
import android.util.Log
import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.iwan.plasmahero_mobile.R
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.iwan.plasmahero_mobile.data.source.remote.RemoteDataSource
import com.iwan.plasmahero_mobile.data.source.remote.responses.EventData
import com.iwan.plasmahero_mobile.data.source.remote.responses.EventResponse
import retrofit2.Response

class MyEventRecyclerViewAdapter(
    public var values: ArrayList<EventData>,
    private var context: Context? = null

) : RecyclerView.Adapter<MyEventRecyclerViewAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        context = parent.context
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.fragment_item_event, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = values[position]
        val imgHolder = holder.ivEvent
        holder.tvPrimary.text = item.title
        holder.tvSecondary.text = item.date
        holder.tvDecs.text = item.desc

        Glide.with(context!!)
            .load(item.imgUrl)
            .override(imgHolder.width, imgHolder.height)
            .centerCrop()
            .diskCacheStrategy(DiskCacheStrategy.ALL)
            .into(imgHolder)
    }

    override fun getItemCount(): Int = values.size

    public fun fetchEventData(){
        val call = RemoteDataSource.getEvent()

        call.enqueue(
            object : retrofit2.Callback<EventResponse>{

                override fun onFailure(call: retrofit2.Call<EventResponse>?, t: Throwable?) {
                    Log.e("getEvents() Failure", t.toString())
                }

                override fun onResponse(call: retrofit2.Call<EventResponse>?, response: Response<EventResponse>?) {
                    if(response?.body()?.success == true){
                        val rs: List<EventData>? = response.body()?.data
                        values = ArrayList(rs)
                        notifyDataSetChanged()

                    }
                }
            }
        )
    }

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val tvPrimary: TextView = view.findViewById(R.id.tvPrimaryEvent)
        val tvSecondary: TextView = view.findViewById(R.id.tvSecondaryEvent)
        val ivEvent: ImageView = view.findViewById(R.id.ivEvent)
        val tvDecs: TextView = view.findViewById(R.id.tvDescEvent)

        override fun toString(): String {
            return super.toString() + " '" + tvPrimary.text + "'"
        }
    }
}