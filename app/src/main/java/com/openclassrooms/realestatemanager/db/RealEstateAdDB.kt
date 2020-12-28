package com.openclassrooms.realestatemanager.db

import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.openclassrooms.realestatemanager.MainApplication
import com.openclassrooms.realestatemanager.model.PhotoEntity
import com.openclassrooms.realestatemanager.model.RealEstateAdEntity

@Database(entities = [(PhotoEntity::class), (RealEstateAdEntity::class)], version = 1)
abstract class RealEstateAdDB : RoomDatabase() {

    companion object {
        val dbInstance: RealEstateAdDB by lazy {
            Room.databaseBuilder(
                MainApplication.instance,
                RealEstateAdDB::class.java,
                "RealEstateAdWithPhoto"
            ).build()
        }
    }

    abstract fun realEstateWithPhotoDao(): RealEstateAdWithPhotoDAO
}