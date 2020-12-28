package com.openclassrooms.realestatemanager.model

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class RealEstateAdEntity(
    @PrimaryKey (autoGenerate = true) val realEstateAdId: Int = 0,
    val realEstateType: String,
    val realEstatePrice: Float,
    val realEstateSurface: Float,
    val realEstateDescription: String,
    val interestPoint: String,
    val realEstateStatue: Boolean,
    val realEstateEntryDate: String,
    val realEstateExitDate: String,
    val realEstateAgent: String,
    val realEstateRoad: String,
    val realEstateHouseNumber: Int,
    val realEstateTown: String,
    val realEstatePostalCode: String,
    val realEstateCountry: String,
    val realEstateTotalRoomNumber: Int,
    val realEstateBedroomNumber: Int,
    val realEstateBathroomNumber: Int
)