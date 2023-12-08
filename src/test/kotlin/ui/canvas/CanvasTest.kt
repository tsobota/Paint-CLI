package ui.canvas

import Paint
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test
import ui.interaction.TestInteraction

class CanvasTest {

    @Test
    fun testCanvasCreation() {

        //for
        val commandPrompts = mutableListOf("C 5 3", "Q")
        val testInteraction = TestInteraction(commandPrompts)
        val paintApp = Paint(testInteraction)

        val expected = """
            -------
            |     |
            |     |
            |     |
            -------
        """.trimIndent()

        //when
        paintApp.run()

        //then
        assertTrue { testInteraction.commandPrompts.isEmpty() }
        assertEquals(expected, testInteraction.displayedCanvas.first())

    }
}