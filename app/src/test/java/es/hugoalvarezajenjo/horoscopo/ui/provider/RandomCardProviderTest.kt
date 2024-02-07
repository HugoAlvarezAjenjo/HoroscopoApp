package es.hugoalvarezajenjo.horoscopo.ui.provider

import org.junit.Assert.*
import org.junit.Test

class RandomCardProviderTest {

    @Test
    fun getRandomCard_should_return_a_random_card() {
        val randomCard = RandomCardProvider()
        val card = randomCard.getLucky()
        assertNotNull(card)
    }
}