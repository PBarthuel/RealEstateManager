package com.openclassrooms.realestatemanager.ui.real_estate_detail

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.openclassrooms.realestatemanager.R

class RealEstateDetailFragment : Fragment() {

    companion object {
        fun newInstance() = RealEstateDetailFragment()
    }

    private lateinit var viewModel: RealEstateDetailViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_real_estate_description, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(RealEstateDetailViewModel::class.java)
        // TODO: Use the ViewModel
    }

}