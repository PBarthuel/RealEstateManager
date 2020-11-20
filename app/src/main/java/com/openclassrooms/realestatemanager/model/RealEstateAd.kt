package com.openclassrooms.realestatemanager.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class RealEstateAd(
    @PrimaryKey var realEstateAdId: Int =0
)