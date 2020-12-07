package com.openclassrooms.realestatemanager.ui.real_estate_list

import androidx.lifecycle.LiveData
import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import com.openclassrooms.realestatemanager.db.RealEstateAdWithPhotoDAO
import com.openclassrooms.realestatemanager.model.RealEstateAdWithPhotoWrapper

class RealEstateListViewModel(
    private val realEstateAdWithPhotoDAO: RealEstateAdWithPhotoDAO
) : ViewModel() {

    fun getUiModelsLiveData(): LiveData<List<RealEstateInfoUiModel>> {
        return Transformations.map(realEstateAdWithPhotoDAO.getRealEstateAdWithPhoto()) { list ->
            list.mapNotNull { entity ->
                null /*RealEstateInfoUiModel(
                    entity.realEstateAd.realEstateAdId,
                    // TODO Mapping à faire
                )*/
            }
        }
    }
}