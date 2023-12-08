package ui.elements.rectangle

import Paint
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test
import ui.interaction.TestInteraction

class HoledOutRectangleTest {
    @Test
    fun testHoledOutRectangleCreation() {
        //for
        val commandPrompts = mutableListOf("C 20 4", "R 14 1 18 3", "Q")
        val testInteraction = TestInteraction(commandPrompts)
        val paintApp = Paint(testInteraction)

        val expected = """
            ----------------------
            |             XXXXX  |
            |             X   X  |
            |             XXXXX  |
            |                    |
            ----------------------
        """.trimIndent()

        //when
        paintApp.run()

        //then
        assertTrue { testInteraction.commandPrompts.isEmpty() }
        assertEquals(expected, testInteraction.displayedCanvas[1])

    }
}