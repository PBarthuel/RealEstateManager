package com.openclassrooms.realestatemanager.ui.real_estate_creation

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.TestCoroutineDispatcher
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.setMain
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.rules.TestRule

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

    // @Before is called before every unit tests
    @Before
    fun setUp() {
        Dispatchers.setMain(testCoroutineDispatcher)
    }

    // @After is called after every unit tests
    @After
    fun tearDown() {
        Dispatchers.resetMain()
        testCoroutineDispatcher.cleanupTestCoroutines()
    }

}