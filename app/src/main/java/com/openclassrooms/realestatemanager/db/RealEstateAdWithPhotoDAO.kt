package com.openclassrooms.realestatemanager.db

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Transaction
import com.openclassrooms.realestatemanager.model.RealEstateAdEntity
import com.openclassrooms.realestatemanager.model.RealEstateAdWithPhotoWrapper

@Dao
interface RealEstateAdWithPhotoDAO {
    @Transaction
    @Query("SELECT * FROM RealEstateAdEntity")
    fun getRealEstateAdWithPhoto(): LiveData<List<RealEstateAdWithPhotoWrapper>>

    @Insert
    fun saveRealEstateAd(realEstateAd: RealEstateAdEntity)
}