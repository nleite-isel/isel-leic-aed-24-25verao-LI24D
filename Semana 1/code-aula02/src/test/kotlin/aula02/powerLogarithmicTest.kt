package aula02

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test


class PowerLogarithmicTest {
    @Test
    fun power_ExponentZero() {
        val result: Int = powerLogarithmic(10, 0)
        assertEquals(1, result)
    }

    @Test
    fun power_EvenExponent() {
        val result: Int = powerLogarithmic(2, 4)
        assertEquals(16, result)
    }

    @Test
    fun power_OddExponent() {
        val result: Int = powerLogarithmic(2, 3)
        assertEquals(8, result)
    }
}