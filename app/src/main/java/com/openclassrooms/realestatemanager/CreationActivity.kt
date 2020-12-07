package com.openclassrooms.realestatemanager

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import androidx.room.Room
import com.openclassrooms.realestatemanager.db.RealEstateAdDB
import com.openclassrooms.realestatemanager.model.RealEstateAd

class CreationActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.creation_real_estate_ad)

        val submitButton: Button = findViewById(R.id.submit_btn)
        val typeEditText: EditText? = findViewById(R.id.type_et)
        val priceEditText: EditText? = findViewById(R.id.price_et)
        val surfaceEditText: EditText? = findViewById(R.id.surface_et)
        val descriptionEditText: EditText? = findViewById(R.id.description_et)
        val entryDateEditText: EditText? = findViewById(R.id.entry_date_et)
        val exitDateEditText: EditText? = findViewById(R.id.exit_date_et)
        val agentEditText: EditText? = findViewById(R.id.agent_et)
        val countryEditText: EditText? = findViewById(R.id.country_et)
        val roadEditText: EditText? = findViewById(R.id.road_et)
        val houseNumberEditText: EditText? = findViewById(R.id.house_number_et)
        val townEditText: EditText? = findViewById(R.id.town_et)
        val postalCodeEditText: EditText? = findViewById(R.id.postal_code_et)
        val totalRoomNumberEditText: EditText? = findViewById(R.id.total_room_number_et)
        val bedroomNumberEditText: EditText? = findViewById(R.id.bedroom_number_et)
        val bathroomNumberEditText: EditText? = findViewById(R.id.bathroom_number_et)
        val photoEditText: Button? = findViewById(R.id.photo_btn)

        var db = Room.databaseBuilder(
            applicationContext,
            RealEstateAdDB::class.java,
            "RealEstateAdWithPhoto"
        )
            .build()

        submitButton.setOnClickListener {
            //Insert Case
            val thread = Thread {

                var realEstateAd = RealEstateAd()
                realEstateAd.realEstateAdId = 3
                realEstateAd.realEstateType = typeEditText?.text.toString()
                realEstateAd.realEstatePrice = priceEditText?.text?.toString()?.toFloatOrNull()
                realEstateAd.realEstateSurface = 152.14f
                realEstateAd.realEstateDescription = descriptionEditText?.text.toString()
                realEstateAd.interestPoint = "good"
                realEstateAd.realEstateStatue = true
                realEstateAd.realEstateEntryDate = entryDateEditText?.text.toString()
                realEstateAd.realEstateExitDate = exitDateEditText?.text.toString()
                realEstateAd.realEstateAgent = agentEditText?.text.toString()
                realEstateAd.realEstateRoad = roadEditText?.text.toString()
                realEstateAd.realEstateHouseNumber = 2
                realEstateAd.realEstateTown = townEditText?.text.toString()
                realEstateAd.realEstatePostalCode = postalCodeEditText?.text.toString()
                realEstateAd.realEstateCountry = countryEditText?.text.toString()
                realEstateAd.realEstateTotalRoomNumber = 5
                realEstateAd.realEstateBedroomNumber = 2
                realEstateAd.realEstateBathroomNumber = 3

                db.realEstateWithPhotoDao().saveRealEstateAd(realEstateAd)

            }
            thread.start()
        }
    }
}