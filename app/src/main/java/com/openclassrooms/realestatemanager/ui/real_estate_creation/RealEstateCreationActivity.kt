package com.openclassrooms.realestatemanager.ui.real_estate_creation

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.openclassrooms.realestatemanager.R
import com.openclassrooms.realestatemanager.injections.ViewModelFactory

class RealEstateCreationActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.creation_real_estate_ad)

        val viewModel =
            ViewModelProvider(this, ViewModelFactory).get(RealEstateCreationViewModel::class.java)

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

        submitButton.setOnClickListener {
            viewModel.createRealEstate(
                realEstateType = typeEditText?.text?.toString(),
                realEstatePrice = priceEditText?.text?.toString(), // TODO A CORRIGER
                realEstateSurface = "152.14",
                realEstateDescription = descriptionEditText?.text?.toString(),
                interestPoint = "good",
                realEstateIsSold = false,
                realEstateEntryDate = entryDateEditText?.text?.toString(),
                realEstateExitDate = exitDateEditText?.text?.toString(),
                realEstateAgent = agentEditText?.text?.toString(),
                realEstateRoad = roadEditText?.text?.toString(),
                realEstateHouseNumber = "2",
                realEstateTown = townEditText?.text?.toString(),
                realEstatePostalCode = postalCodeEditText?.text?.toString(),
                realEstateCountry = countryEditText?.text?.toString(),
                realEstateTotalRoomNumber = "5",
                realEstateBedroomNumber = "2",
                realEstateBathroomNumber = "3"
            )
        }

        viewModel.liveDataViewAction.observe(this) {
            finish()
        }
    }
}