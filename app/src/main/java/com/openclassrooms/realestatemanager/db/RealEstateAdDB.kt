package com.openclassrooms.realestatemanager.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.openclassrooms.realestatemanager.model.Photo
import com.openclassrooms.realestatemanager.model.RealEstateAd

@Database(entities = [(Photo::class), (RealEstateAd::class)],version = 1)
abstract class RealEstateAdDB : RoomDatabase() {

    abstract fun realEstateWithPhotoDao(): RealEstateAdWithPhotoDAO
}