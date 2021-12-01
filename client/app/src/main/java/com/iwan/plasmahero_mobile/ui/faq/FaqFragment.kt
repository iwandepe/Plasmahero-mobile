package com.iwan.plasmahero_mobile.ui.faq

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.iwan.plasmahero_mobile.R
import com.iwan.plasmahero_mobile.data.model.EventModel
import com.iwan.plasmahero_mobile.data.model.FaqModel

/**
 * A fragment representing a list of Items.
 */
class FaqFragment : Fragment() {

    private var columnCount = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        arguments?.let {
            columnCount = it.getInt(ARG_COLUMN_COUNT)
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_faq, container, false)
        val loadingBar : com.google.android.material.progressindicator.CircularProgressIndicator = requireActivity().findViewById(R.id.loadingBar)

        val faqList: ArrayList<FaqModel.FaqValue> = FaqModel.fetchFaqData()
//        loadingBar.visibility = View.GONE

        // Set the adapter
        if (view is RecyclerView) {
            with(view) {
                layoutManager = when {
                    columnCount <= 1 -> LinearLayoutManager(context)
                    else -> GridLayoutManager(context, columnCount)
                }

                adapter = MyFaqRecyclerViewAdapter(faqList)


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
                FaqFragment().apply {
                    arguments = Bundle().apply {
                        putInt(ARG_COLUMN_COUNT, columnCount)
                    }
                }
    }
}