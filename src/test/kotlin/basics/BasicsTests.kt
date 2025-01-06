package basics

import kotlin.test.Test
import kotlin.test.assertEquals

import org.junit.jupiter.api.Assertions.*

class BasicsTests {

    @Test
    fun testTrack() {
        val track = Track("Alice", "Private Seemore", 4.17)
        println(track.title)
    }
}