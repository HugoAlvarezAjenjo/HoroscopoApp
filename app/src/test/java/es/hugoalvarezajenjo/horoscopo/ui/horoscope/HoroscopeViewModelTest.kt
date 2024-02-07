package es.hugoalvarezajenjo.horoscopo.ui.horoscope

import es.hugoalvarezajenjo.horoscopo.data.provider.HoroscopeProvider
import es.hugoalvarezajenjo.horoscopo.motherobject.HoroscopeMotherObject
import io.mockk.MockKAnnotations
import io.mockk.every
import io.mockk.impl.annotations.MockK
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test

class HoroscopeViewModelTest {

    @MockK
    lateinit var horoscopeProvider: HoroscopeProvider

    private lateinit var viewModel: HoroscopeViewModel

    @Before
    fun setUp() {
        MockKAnnotations.init(this, relaxUnitFun = true)
    }

    @Test
    fun when_viewModel_is_created_then_horoscopes_are_loaded() {
        every { horoscopeProvider.getHoroscopes() } returns HoroscopeMotherObject.horoscopeInfoList
        viewModel = HoroscopeViewModel(horoscopeProvider)

        val horoscopes = viewModel.horoscope.value
        assertTrue(horoscopes.isNotEmpty())
    }
}