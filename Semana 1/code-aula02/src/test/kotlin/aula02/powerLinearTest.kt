package aula02

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class powerLinearTest {
    @Test
    fun power_ExponentZero() {
        assertEquals(1, powerLinear(10, 0))
    }

    @Test
    fun power_EvenExponent() {
        assertEquals(16, powerLinear(2, 4))
    }

    @Test
    fun power_OddExponent() {
        assertEquals(8, powerLinear(2, 3))
    }

}