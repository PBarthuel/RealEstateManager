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
            list.map { entity ->
                 RealEstateInfoUiModel(
                    entity.realEstateAd.realEstateAdId,
                    entity.realEstateAd.realEstateType,
                    entity.realEstateAd.realEstatePrice.toString(),
                    entity.realEstateAd.realEstateSurface.toString(),
                    entity.realEstateAd.realEstateDescription,
                    entity.realEstateAd.interestPoint,
                    entity.realEstateAd.realEstateStatue,
                    entity.realEstateAd.realEstateEntryDate,
                    entity.realEstateAd.realEstateExitDate,
                    entity.realEstateAd.realEstateAgent,
                    entity.realEstateAd.realEstateRoad,
                    entity.realEstateAd.realEstateHouseNumber.toString(),
                    entity.realEstateAd.realEstateTown,
                    entity.realEstateAd.realEstatePostalCode,
                    entity.realEstateAd.realEstateCountry,
                    entity.realEstateAd.realEstateTotalRoomNumber.toString(),
                    entity.realEstateAd.realEstateBedroomNumber.toString(),
                    entity.realEstateAd.realEstateBathroomNumber.toString(),
                    entity.photos.map {
                        it.photoReference
                    }
                )
            }
        }
    }
}