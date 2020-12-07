package com.openclassrooms.realestatemanager.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class RealEstateAd(
    @PrimaryKey var realEstateAdId: Int =0,
    var realEstateType: String? = null,
    var realEstatePrice: Float? = null,
    var realEstateSurface: Float? = null,
    var realEstateDescription: String? = null,
    var interestPoint: String? = null,
    var realEstateStatue: Boolean? = null,
    var realEstateEntryDate: String? = null,
    var realEstateExitDate: String? = null,
    var realEstateAgent: String? = null,
    var realEstateRoad: String? = null,
    var realEstateHouseNumber: Int? = null,
    var realEstateTown: String? = null,
    var realEstatePostalCode: String? = null,
    var realEstateCountry: String? = null,
    var realEstateTotalRoomNumber: Int? = null,
    var realEstateBedroomNumber: Int? = null,
    var realEstateBathroomNumber: Int? = null
)