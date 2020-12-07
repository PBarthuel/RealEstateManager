package com.openclassrooms.realestatemanager.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.openclassrooms.realestatemanager.model.PhotoEntity
import com.openclassrooms.realestatemanager.model.RealEstateAdEntity

@Database(entities = [(PhotoEntity::class), (RealEstateAdEntity::class)],version = 1)
abstract class RealEstateAdDB : RoomDatabase() {

    abstract fun realEstateWithPhotoDao(): RealEstateAdWithPhotoDAO
}