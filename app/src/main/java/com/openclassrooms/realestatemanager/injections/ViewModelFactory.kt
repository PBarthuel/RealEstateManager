package com.openclassrooms.realestatemanager.injections

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.openclassrooms.realestatemanager.db.RealEstateAdWithPhotoDAO
import com.openclassrooms.realestatemanager.ui.real_estate_list.RealEstateListViewModel

@Suppress("UNCHECKED_CAST")
class ViewModelFactory private constructor(private val realEstateAdWithPhotoDAO: RealEstateAdWithPhotoDAO) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(RealEstateListViewModel::class.java)) {
            return RealEstateListViewModel(this.realEstateAdWithPhotoDAO) as T
        }

        throw IllegalArgumentException("Unknown ViewModel class")
    }
}