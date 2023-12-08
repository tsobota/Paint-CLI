package ui.elements.line

import Paint
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test
import ui.interaction.TestInteraction

class VerticalLineTest {
    @Test
    fun testVerticalLineCreation() {
        //for
        val commandPrompts = mutableListOf("C 5 3", "L 3 1 3 3", "Q")
        val testInteraction = TestInteraction(commandPrompts)
        val paintApp = Paint(testInteraction)

        val expected = """
            -------
            |  X  |
            |  X  |
            |  X  |
            -------
        """.trimIndent()

        //when
        paintApp.run()

        //then
        assertTrue { testInteraction.commandPrompts.isEmpty() }
        assertEquals(expected, testInteraction.displayedCanvas[1])

    }
}