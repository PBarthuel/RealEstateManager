package com.openclassrooms.realestatemanager.db

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Transaction
import com.openclassrooms.realestatemanager.model.RealEstateAd
import com.openclassrooms.realestatemanager.model.RealEstateAdWithPhoto

@Dao
interface RealEstateAdWithPhotoDAO
{
    @Transaction
    @Query("SELECT * FROM RealEstateAd")
    fun getRealEstateAdWithPhoto(): LiveData<List<RealEstateAdWithPhoto>>

    @Insert
    fun saveRealEstateAd(realEstateAd: RealEstateAd)
}