package com.iwan.plasmahero_mobile.ui.faq

import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.iwan.plasmahero_mobile.R
import com.iwan.plasmahero_mobile.data.model.FaqModel

class MyFaqRecyclerViewAdapter(
        private val values: ArrayList<FaqModel.FaqValue>)
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

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val tvQuestion: TextView = view.findViewById(R.id.tvQuestion)
        val tvAnswer: TextView = view.findViewById(R.id.tvAnswer)

        override fun toString(): String {
            return super.toString() + " '" + tvQuestion.text + "'"
        }
    }
}