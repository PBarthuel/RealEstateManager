package com.openclassrooms.realestatemanager.db

import androidx.room.Dao
import androidx.room.Query
import androidx.room.Transaction
import com.openclassrooms.realestatemanager.model.RealEstateAdWithPhoto

@Dao
interface RealEstateAdWithPhotoDAO
{
    @Transaction
    @Query("SELECT * FROM RealEstateAd")
    fun getRealEstateAdWithPhoto(): List<RealEstateAdWithPhoto>
}