package com.iwan.plasmahero_mobile.ui.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.google.android.material.card.MaterialCardView
import com.iwan.plasmahero_mobile.R

class RoleOptionFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_role_option, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val mcvDonor = view.findViewById<MaterialCardView>(R.id.mcvDonor)
        val mcvRecipient = view.findViewById<MaterialCardView>(R.id.mcvRecipient)

        mcvDonor.setOnClickListener{
            val navController = findNavController()
            navController.navigate(R.id.action_navigation_role_option_to_navigation_donor_form)
        }

        mcvRecipient.setOnClickListener{
            val navController = findNavController()
            navController.navigate(R.id.action_navigation_role_option_to_navigation_recipient_form)
        }
    }
}