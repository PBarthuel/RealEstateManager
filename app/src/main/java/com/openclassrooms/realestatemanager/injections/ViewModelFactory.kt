package com.openclassrooms.realestatemanager.injections

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.openclassrooms.realestatemanager.db.RealEstateAdDB
import com.openclassrooms.realestatemanager.ui.creation.RealEstateCreationViewModel
import com.openclassrooms.realestatemanager.ui.real_estate_list.RealEstateListViewModel

@Suppress("UNCHECKED_CAST")
object ViewModelFactory : ViewModelProvider.Factory {

    private val realEstateAdWithPhotoDAO = RealEstateAdDB.dbInstance.realEstateWithPhotoDao()

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return when {
            modelClass.isAssignableFrom(RealEstateListViewModel::class.java) ->
                RealEstateListViewModel(realEstateAdWithPhotoDAO) as T
            modelClass.isAssignableFrom(RealEstateCreationViewModel::class.java) ->
                RealEstateCreationViewModel(realEstateAdWithPhotoDAO) as T
            else -> throw IllegalArgumentException("Unknown ViewModel class")
        }
    }
}