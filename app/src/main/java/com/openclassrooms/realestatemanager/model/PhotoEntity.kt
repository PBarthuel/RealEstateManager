package com.openclassrooms.realestatemanager.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class PhotoEntity(
    @PrimaryKey (autoGenerate = true) val photoId: Int = 0,
    val photoRealEstateAdId: Int = 0,
    val photoReference: String
)