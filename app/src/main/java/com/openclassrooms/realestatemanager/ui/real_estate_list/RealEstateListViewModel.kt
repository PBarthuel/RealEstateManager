package com.openclassrooms.realestatemanager.ui.real_estate_list

import androidx.lifecycle.LiveData
import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.ViewModel
import com.openclassrooms.realestatemanager.model.RealEstateAdWithPhoto

class RealEstateListViewModel : ViewModel() {

    private val mediatorRestaurantInfo: MediatorLiveData<List<RealEstateAdWithPhoto>> =
        MediatorLiveData<List<RealEstateAdWithPhoto>>()

    fun getUiModelsLiveData(): MediatorLiveData<List<RealEstateAdWithPhoto>> {
        return mediatorRestaurantInfo
    }

}