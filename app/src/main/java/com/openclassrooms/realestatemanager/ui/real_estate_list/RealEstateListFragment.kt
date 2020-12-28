package com.openclassrooms.realestatemanager.ui.real_estate_list

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.openclassrooms.realestatemanager.R
import com.openclassrooms.realestatemanager.injections.ViewModelFactory
import kotlinx.android.synthetic.main.real_estate_ad_recycler_view.*

class RealEstateListFragment : Fragment() {

    companion object {
        fun newInstance() = RealEstateListFragment()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_real_estate_list, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        val viewModel = ViewModelProvider(this, ViewModelFactory).get(RealEstateListViewModel::class.java)
        val realEstateAdAdapter = RealEstateAdAdapter()
        real_estate_ad_recycler_view.apply {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = realEstateAdAdapter
            viewModel.getUiModelsLiveData().observe(viewLifecycleOwner, Observer {
                Log.i("courgette", "$it")
                realEstateAdAdapter.submitList(it)
            })
        }
    }

}