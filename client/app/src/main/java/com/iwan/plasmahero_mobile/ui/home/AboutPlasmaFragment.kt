package com.iwan.plasmahero_mobile.ui.home

import android.app.Activity
import android.content.res.Resources
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.LinearLayout
import android.widget.ListView
import android.widget.TextView
import com.iwan.plasmahero_mobile.R
import com.skydoves.expandablelayout.ExpandableLayout

class AboutPlasmaFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_about_plasma, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val expDonorCondition = view.findViewById<LinearLayout>(R.id.expandableDonorCondition)
        val expDonorPlot = view.findViewById<LinearLayout>(R.id.expandableDonorPlot)
        val expGetDonorPlot = view.findViewById<LinearLayout>(R.id.expandableGetDonorPlot)
        val expGetDonorPlotNoAvailable = view.findViewById<LinearLayout>(R.id.expandableGetDonorPlotNoAvailable)

        val res: Resources = resources
        val donorConditionList = res.getStringArray(R.array.donor_condition)
        val donorConditionAdapter = ItemAdapter(requireActivity(), donorConditionList)
        val lvDonorCondition = view.findViewById<ListView>(R.id.lvAboutPlasmaExpandableItem1)
        lvDonorCondition.adapter = donorConditionAdapter
        view.findViewById<TextView>(R.id.tvAboutPlasmaExpandableParent1).text = getString(R.string.text_donor_condition)

        val donorPlotList = res.getStringArray(R.array.donor_plot)
        val donorPlotAdapter = ItemAdapter(requireActivity(), donorPlotList)
        val lvDonorPlot = view.findViewById<ListView>(R.id.lvAboutPlasmaExpandableItem2)
        lvDonorPlot.adapter = donorPlotAdapter
        view.findViewById<TextView>(R.id.tvAboutPlasmaExpandableParent2).text = getString(R.string.text_donor_plot)

        val getDonorPlotList = res.getStringArray(R.array.get_donor_plot)
        val getDonorPlotAdapter = ItemAdapter(requireActivity(), getDonorPlotList)
        val lvGetDonorPlot = view.findViewById<ListView>(R.id.lvAboutPlasmaExpandableItem3)
        lvGetDonorPlot.adapter = getDonorPlotAdapter
        view.findViewById<TextView>(R.id.tvAboutPlasmaExpandableParent3).text = getString(R.string.text_get_donor_plot)

        val getDonorPlotNoAvailableList = res.getStringArray(R.array.get_donor_plot_no_available)
        val getDonorPlotNoAvailableAdapter = ItemAdapter(requireActivity(), getDonorPlotNoAvailableList)
        val lvGetDonorPlotNoAvailable = view.findViewById<ListView>(R.id.lvAboutPlasmaExpandableItem4)
        lvGetDonorPlotNoAvailable.adapter = getDonorPlotNoAvailableAdapter
        view.findViewById<TextView>(R.id.tvAboutPlasmaExpandableParent4).text = getString(R.string.text_get_donor_plot_no_available)
    }

    class ItemAdapter(private val context: Activity, private val items: Array<String>)
        : ArrayAdapter<String>(context, R.layout.fragment_about_plasma_expandable_second_list_item, items) {

        override fun getView(position: Int, view: View?, parent: ViewGroup): View {
            val inflater = context.layoutInflater
            val view = inflater.inflate(R.layout.fragment_about_plasma_expandable_second_list_item, null, true)

            val tvItem = view.findViewById(R.id.tvAboutPlasmaExpandableListItem) as TextView

            tvItem.text = items[position]

            return view
        }
    }
}