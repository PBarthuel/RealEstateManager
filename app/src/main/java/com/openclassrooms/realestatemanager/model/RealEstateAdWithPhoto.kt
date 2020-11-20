package com.openclassrooms.realestatemanager.model

import androidx.room.Embedded
import androidx.room.Relation

data class RealEstateAdWithPhoto(
    @Embedded val realEstateAd: RealEstateAd,
    @Relation(
        parentColumn = "RealEstateAdId",
        entityColumn = "photoRealEstateAdId"
    )
    val photos: List<Photo>
)