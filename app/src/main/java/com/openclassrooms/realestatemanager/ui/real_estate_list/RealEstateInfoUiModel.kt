package com.openclassrooms.realestatemanager.ui.real_estate_list

data class RealEstateInfoUiModel(
    val realEstateAdId: Int,
    val realEstateType: String,
    val realEstatePrice: String,
    val realEstateSurface: String,
    val realEstateDescription: String,
    val interestPoint: String,
    val realEstateStatue: String,
    val realEstateEntryDate: String,
    val realEstateExitDate: String,
    val realEstateAgent: String,
    val realEstateRoad: String,
    val realEstateHouseNumber: String,
    val realEstateTown: String,
    val realEstatePostalCode: String,
    val realEstateCountry: String,
    val realEstateTotalRoomNumber: String,
    val realEstateBedroomNumber: String,
    val realEstateBathroomNumber: String,
    val photoUrl: List<String>,
    val isRealEstateSoldImageVisible: Boolean
)
