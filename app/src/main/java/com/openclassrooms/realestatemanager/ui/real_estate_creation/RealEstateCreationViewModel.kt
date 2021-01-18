package com.openclassrooms.realestatemanager.ui.real_estate_creation

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.openclassrooms.realestatemanager.R
import com.openclassrooms.realestatemanager.db.RealEstateAdWithPhotoDAO
import com.openclassrooms.realestatemanager.model.RealEstateAdEntity
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class RealEstateCreationViewModel(
    private val realEstateAdWithPhotoDAO: RealEstateAdWithPhotoDAO
) : ViewModel() {

    val liveDataViewAction = MutableLiveData<RealEstateCreationViewAction>()

    sealed class RealEstateCreationViewAction {
        object CloseActivity : RealEstateCreationViewAction()
        data class DisplayToast(val messageResId: Int) : RealEstateCreationViewAction()
    }

    fun createRealEstate(realEstateCreationViewInfo :RealEstateCreationViewInfo) {
        with (realEstateCreationViewInfo) {
            val realEstatePriceParsed = realEstatePrice?.toFloatOrNull()
            if (realEstatePriceParsed == null) {
                liveDataViewAction.value =
                    RealEstateCreationViewAction.DisplayToast(R.string.error_incorrect_price)
                return
            }
            if (realEstateType == null) {
                liveDataViewAction.value =
                    RealEstateCreationViewAction.DisplayToast(R.string.error_incorrect_price)
                return
            }
        //    viewModelScope.launch(Dispatchers.IO) {
                // TODO Si besoin la primary key autogenerated se récupère comme ça
                val realEstateId = realEstateAdWithPhotoDAO.saveRealEstateAd(
                    RealEstateAdEntity(
                        0,
                        realEstateType,
                        realEstatePriceParsed,
                        0f,
                        "",
                        "",
                        false,
                        "",
                        "",
                        "",
                        "",
                        0,
                        "",
                        "",
                        "",
                        0,
                        0,
                        0
                    )
                )

//                withContext(Dispatchers.Main) {
//                    liveDataViewAction.value = RealEstateCreationViewAction.CloseActivity
//                }
//            }
        }
    }

    class RealEstateCreationViewInfo(
        val realEstateType: String?,
        val realEstatePrice: String?,
        val realEstateSurface: String?,
        val realEstateDescription: String?,
        val interestPoint: String?,
        val realEstateIsSold: Boolean,
        val realEstateEntryDate: String?,
        val realEstateExitDate: String?,
        val realEstateAgent: String?,
        val realEstateRoad: String?,
        val realEstateHouseNumber: String?,
        val realEstateTown: String?,
        val realEstatePostalCode: String?,
        val realEstateCountry: String?,
        val realEstateTotalRoomNumber: String?,
        val realEstateBedroomNumber: String?,
        val realEstateBathroomNumber: String?
    )
}