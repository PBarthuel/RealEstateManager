package com.openclassrooms.realestatemanager.ui.real_estate_creation

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.openclassrooms.realestatemanager.R
import com.openclassrooms.realestatemanager.injections.ViewModelFactory
import com.openclassrooms.realestatemanager.ui.real_estate_creation.RealEstateCreationViewModel.RealEstateCreationViewInfo

class RealEstateCreationActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.creation_real_estate_ad)

        val viewModel =
            ViewModelProvider(this, ViewModelFactory).get(RealEstateCreationViewModel::class.java)

        val submitButton = findViewById<Button>(R.id.submit_btn)
        val typeEditText = findViewById<EditText>(R.id.type_et)
        val priceEditText = findViewById<EditText>(R.id.price_et)
        val surfaceEditText = findViewById<EditText>(R.id.surface_et)
        val descriptionEditText = findViewById<EditText>(R.id.description_et)
        val entryDateEditText = findViewById<EditText>(R.id.entry_date_et)
        val exitDateEditText = findViewById<EditText>(R.id.exit_date_et)
        val agentEditText = findViewById<EditText>(R.id.agent_et)
        val countryEditText = findViewById<EditText>(R.id.country_et)
        val roadEditText = findViewById<EditText>(R.id.road_et)
        val houseNumberEditText = findViewById<EditText>(R.id.house_number_et)
        val townEditText = findViewById<EditText>(R.id.town_et)
        val postalCodeEditText = findViewById<EditText>(R.id.postal_code_et)
        val totalRoomNumberEditText = findViewById<EditText>(R.id.total_room_number_et)
        val bedroomNumberEditText = findViewById<EditText>(R.id.bedroom_number_et)
        val bathroomNumberEditText = findViewById<EditText>(R.id.bathroom_number_et)
        val photoEditText = findViewById<Button>(R.id.photo_btn)

        submitButton.setOnClickListener {
            viewModel.createRealEstate(
                RealEstateCreationViewInfo(
                    realEstateType = typeEditText.text?.toString(),
                    realEstatePrice = priceEditText.text?.toString(), // TODO A CORRIGER
                    realEstateSurface = "152.14",
                    realEstateDescription = descriptionEditText.text?.toString(),
                    interestPoint = "good",
                    realEstateIsSold = false,
                    realEstateEntryDate = entryDateEditText.text?.toString(),
                    realEstateExitDate = exitDateEditText.text?.toString(),
                    realEstateAgent = agentEditText.text?.toString(),
                    realEstateRoad = roadEditText.text?.toString(),
                    realEstateHouseNumber = "2",
                    realEstateTown = townEditText.text?.toString(),
                    realEstatePostalCode = postalCodeEditText.text?.toString(),
                    realEstateCountry = countryEditText.text?.toString(),
                    realEstateTotalRoomNumber = "5",
                    realEstateBedroomNumber = "2",
                    realEstateBathroomNumber = "3"
                )
            )
        }

        viewModel.liveDataViewAction.observe(this) {
            finish()
        }
    }
}