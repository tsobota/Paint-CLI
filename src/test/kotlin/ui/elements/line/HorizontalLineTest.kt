package ui.elements.line

import Paint
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test
import ui.interaction.TestInteraction

class HorizontalLineTest {

    @Test
    fun testHorizontalLineCreation() {
        //for
        val commandPrompts = mutableListOf("C 5 3", "L 1 1 5 1", "Q")
        val testInteraction = TestInteraction(commandPrompts)
        val paintApp = Paint(testInteraction)

        val expected = """
            -------
            |XXXXX|
            |     |
            |     |
            -------
        """.trimIndent()

        //when
        paintApp.run()

        //then
        assertTrue { testInteraction.commandPrompts.isEmpty() }
        assertEquals(expected, testInteraction.displayedCanvas[1])
    }
}