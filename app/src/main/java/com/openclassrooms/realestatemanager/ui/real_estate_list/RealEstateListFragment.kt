package com.openclassrooms.realestatemanager.ui.real_estate_list

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.openclassrooms.realestatemanager.R

class RealEstateListFragment : Fragment() {

    companion object {
        fun newInstance() = RealEstateListFragment()
    }

    private lateinit var viewModel: RealEstateListViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_real_estate_list, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(RealEstateListViewModel::class.java)
        // TODO: Use the ViewModel
    }

}