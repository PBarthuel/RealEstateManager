package com.openclassrooms.realestatemanager.db

import androidx.lifecycle.LiveData
import androidx.room.*
import com.openclassrooms.realestatemanager.model.RealEstateAdEntity
import com.openclassrooms.realestatemanager.model.RealEstateAdWithPhotoWrapper

@Dao
interface RealEstateAdWithPhotoDAO {
    @Transaction
    @Query("SELECT * FROM RealEstateAdEntity")
    fun getRealEstateAdWithPhoto(): LiveData<List<RealEstateAdWithPhotoWrapper>>

    @Insert
    suspend fun saveRealEstateAd(realEstateAd: RealEstateAdEntity) : Long

    @Update
    fun updateRealEstateAd(realEstateAd: RealEstateAdEntity)

    @Delete
    fun deleteRealEstateAd(realEstateAd: RealEstateAdEntity)
}