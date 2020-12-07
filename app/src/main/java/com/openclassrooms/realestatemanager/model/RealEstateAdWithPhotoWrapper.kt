package com.openclassrooms.realestatemanager.model

import androidx.room.Embedded
import androidx.room.Relation

data class RealEstateAdWithPhotoWrapper(
    @Embedded val realEstateAd: RealEstateAdEntity,
    @Relation(
        parentColumn = "realEstateAdId",
        entityColumn = "photoRealEstateAdId"
    )
    val photos: List<PhotoEntity?>
)