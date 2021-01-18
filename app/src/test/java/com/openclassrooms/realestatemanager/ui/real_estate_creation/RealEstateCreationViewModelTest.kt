package com.openclassrooms.realestatemanager.ui.real_estate_creation

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.openclassrooms.realestatemanager.R
import com.openclassrooms.realestatemanager.db.RealEstateAdWithPhotoDAO
import com.openclassrooms.realestatemanager.ui.real_estate_creation.RealEstateCreationViewModel.RealEstateCreationViewInfo
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.TestCoroutineDispatcher
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.setMain
import org.junit.After
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.rules.TestRule
import org.mockito.Mockito

@ExperimentalCoroutinesApi
class RealEstateCreationViewModelTest {

    // Instant update of the LiveDatas thanks to the InstantTaskExecutorRule (not really in this case because we switch
    // thread ourselves with *withContext(Dispatchers.Main)* but whatever this is usefull to know)
    // Note : A rule apply to every tests in this class
    @get:Rule
    var rule: TestRule = InstantTaskExecutorRule()

    // "Rule" so that Coroutines use the same (and only one) Thread
    // This is an alternative way to set up a "rule". But it's more conventionnal
    // to extend a TestWatcher and use it as a Rule instead.
    private val testCoroutineDispatcher = TestCoroutineDispatcher()

    private val realEstateAdWithPhotoDAO = Mockito.mock(RealEstateAdWithPhotoDAO::class.java)

    private lateinit var viewModel: RealEstateCreationViewModel

    // @Before is called before every unit tests
    @Before
    fun setUp() {
        Dispatchers.setMain(testCoroutineDispatcher)

        viewModel = RealEstateCreationViewModel(realEstateAdWithPhotoDAO)
    }

    // @After is called after every unit tests
    @After
    fun tearDown() {
        Dispatchers.resetMain()
        testCoroutineDispatcher.cleanupTestCoroutines()
    }

    @Test
    fun `nominal case - real estate should be inserted to database and view is finished`() {
        // Given
       // Mockito.doNothing().`when`(realEstateAdWithPhotoDAO).saveRealEstateAd(Mockito.any())

        // When
        viewModel.createRealEstate(getDefaultRealEstateCreationViewInfo())

        viewModel.liveDataViewAction.observeForTesting {
            // Then
            assertEquals(
                RealEstateCreationViewModel.RealEstateCreationViewAction.CloseActivity,
                it.value
            )

            Mockito.verify(realEstateAdWithPhotoDAO).saveRealEstateAd(Mockito.any())
        }
    }

    @Test
    fun `error case - toast should be displayed when price in incorrect`() {
        // Given
        Mockito.doNothing().`when`(realEstateAdWithPhotoDAO).saveRealEstateAd(Mockito.any())

        // When
        viewModel.createRealEstate(
            getDefaultRealEstateCreationViewInfo(
                realEstatePrice = "0.0.0"
            )
        )

        viewModel.liveDataViewAction.observeForTesting {
            // Then
            assertEquals(
                it.value,
                RealEstateCreationViewModel.RealEstateCreationViewAction.DisplayToast(
                    R.string.error_incorrect_price
                )
            )

            Mockito.verify(realEstateAdWithPhotoDAO, Mockito.never()).saveRealEstateAd(Mockito.any())
        }
    }

    companion object {
        private const val EXPECTED_REAL_ESTATE_TYPE = "EXPECTED_REAL_ESTATE_TYPE"
        private const val EXPECTED_REAL_ESTATE_PRICE = "300000"
        private const val EXPECTED_REAL_ESTATE_SURFACE = "EXPECTED_REAL_ESTATE_SURFACE"
        private const val EXPECTED_REAL_ESTATE_DESCRIPTION = "EXPECTED_REAL_ESTATE_DESCRIPTION"
    }

    // region IN
    private fun getDefaultRealEstateCreationViewInfo(
        realEstateType: String? = EXPECTED_REAL_ESTATE_TYPE,
        realEstatePrice: String? = EXPECTED_REAL_ESTATE_PRICE,
        realEstateSurface: String? = EXPECTED_REAL_ESTATE_SURFACE,
        realEstateDescription: String? = EXPECTED_REAL_ESTATE_DESCRIPTION,
        interestPoint: String? = "",
        realEstateIsSold: Boolean = false,
        realEstateEntryDate: String? = "",
        realEstateExitDate: String? = "",
        realEstateAgent: String? = "",
        realEstateRoad: String? = "",
        realEstateHouseNumber: String? = "",
        realEstateTown: String? = "",
        realEstatePostalCode: String? = "",
        realEstateCountry: String? = "",
        realEstateTotalRoomNumber: String? = "",
        realEstateBedroomNumber: String? = "",
        realEstateBathroomNumber: String? = ""
    ): RealEstateCreationViewInfo {
        return RealEstateCreationViewInfo(
            realEstateType = realEstateType,
            realEstatePrice = realEstatePrice,
            realEstateSurface = realEstateSurface,
            realEstateDescription = realEstateDescription,
            interestPoint = interestPoint,
            realEstateIsSold = realEstateIsSold,
            realEstateEntryDate = realEstateEntryDate,
            realEstateExitDate = realEstateExitDate,
            realEstateAgent = realEstateAgent,
            realEstateRoad = realEstateRoad,
            realEstateHouseNumber = realEstateHouseNumber,
            realEstateTown = realEstateTown,
            realEstatePostalCode = realEstatePostalCode,
            realEstateCountry = realEstateCountry,
            realEstateTotalRoomNumber = realEstateTotalRoomNumber,
            realEstateBedroomNumber = realEstateBedroomNumber,
            realEstateBathroomNumber = realEstateBathroomNumber
        )
    }
    // endregion
}