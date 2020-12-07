package com.openclassrooms.realestatemanager.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class PhotoEntity(
    @PrimaryKey var photoId: Int = 0,
    var photoRealEstateAdId: Int = 0,
    var photoReference: String
)