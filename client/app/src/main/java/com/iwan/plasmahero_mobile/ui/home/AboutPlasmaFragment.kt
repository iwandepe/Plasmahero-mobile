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

        val expDonorCondition = view.findViewById<ExpandableLayout>(R.id.expandableDonorCondition)
        val expDonorPlot = view.findViewById<ExpandableLayout>(R.id.expandableDonorPlot)
        val expGetDonorPlot = view.findViewById<ExpandableLayout>(R.id.expandableGetDonorPlot)
        val expGetDonorPlotNoAvailable = view.findViewById<ExpandableLayout>(R.id.expandableGetDonorPlotNoAvailable)

        val res: Resources = resources
        val donorConditionList = res.getStringArray(R.array.donor_condition)
        val donorConditionAdapter = ItemAdapter(requireActivity(), donorConditionList)
        val lvDonorCondition = expDonorCondition.secondLayout.findViewById<ListView>(R.id.lvAboutPlasmaExpandableItem)
        lvDonorCondition.adapter = donorConditionAdapter
        expDonorCondition.parentLayout.findViewById<TextView>(R.id.tvAboutPlasmaExpandableParent).text = getString(R.string.text_donor_condition)
        expDonorCondition.setOnClickListener {
            Log.v("Expandable", "Expandable Donor Condition Clicked")
            if (expDonorCondition.isExpanded){
                expDonorCondition.collapse()
            }
            else {
                expDonorCondition.expand()
                expDonorCondition.collapse()
                expDonorPlot.collapse()
                expGetDonorPlot.collapse()
                expGetDonorPlotNoAvailable.collapse()
            }
        }

        val donorPlotList = res.getStringArray(R.array.donor_plot)
        val donorPlotAdapter = ItemAdapter(requireActivity(), donorPlotList)
        val lvDonorPlot = expDonorPlot.secondLayout.findViewById<ListView>(R.id.lvAboutPlasmaExpandableItem)
        lvDonorPlot.adapter = donorPlotAdapter
        expDonorPlot.parentLayout.findViewById<TextView>(R.id.tvAboutPlasmaExpandableParent).text = getString(R.string.text_donor_plot)
        expDonorPlot.setOnClickListener {
            Log.v("Expandable", "Expandable Donor Plot Clicked")
            if (expDonorPlot.isExpanded){
                expDonorPlot.collapse()
            }
            else {
                expDonorPlot.expand()
                expDonorCondition.collapse()
                expGetDonorPlot.collapse()
                expGetDonorPlotNoAvailable.collapse()
            }
        }

        val getDonorPlotList = res.getStringArray(R.array.get_donor_plot)
        val getDonorPlotAdapter = ItemAdapter(requireActivity(), getDonorPlotList)
        val lvGetDonorPlot = expGetDonorPlot.secondLayout.findViewById<ListView>(R.id.lvAboutPlasmaExpandableItem)
        lvGetDonorPlot.adapter = getDonorPlotAdapter
        expGetDonorPlot.parentLayout.findViewById<TextView>(R.id.tvAboutPlasmaExpandableParent).text = getString(R.string.text_get_donor_plot)
        expGetDonorPlot.setOnClickListener {
            Log.v("Expandable", "Expandable Get Donor Plot Clicked")
            if (expGetDonorPlot.isExpanded){
                expGetDonorPlot.collapse()
            }
            else {
                expGetDonorPlot.expand()
                expDonorCondition.collapse()
                expDonorPlot.collapse()
                expGetDonorPlotNoAvailable.collapse()
            }
        }

        val getDonorPlotNoAvailableList = res.getStringArray(R.array.get_donor_plot_no_available)
        val getDonorPlotNoAvailableAdapter = ItemAdapter(requireActivity(), getDonorPlotNoAvailableList)
        val lvGetDonorPlotNoAvailable = expGetDonorPlotNoAvailable.secondLayout.findViewById<ListView>(R.id.lvAboutPlasmaExpandableItem)
        lvGetDonorPlotNoAvailable.adapter = getDonorPlotNoAvailableAdapter
        expGetDonorPlotNoAvailable.parentLayout.findViewById<TextView>(R.id.tvAboutPlasmaExpandableParent).text = getString(R.string.text_get_donor_plot_no_available)
        expGetDonorPlotNoAvailable.setOnClickListener {
            Log.v("Expandable", "Expandable Get Donor Plot No Available Clicked")
            if (expGetDonorPlotNoAvailable.isExpanded) {
                expGetDonorPlotNoAvailable.collapse()
            }
            else {
                expGetDonorPlotNoAvailable.expand()
                expDonorCondition.collapse()
                expDonorPlot.collapse()
                expGetDonorPlot.collapse()
            }
        }
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