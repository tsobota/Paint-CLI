package ui.interaction.command.executors

import Paint
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test
import ui.canvas.Canvas
import ui.interaction.TestInteraction

class CanvasCommandTest {
    @Test
    fun testMultipleWrongCommands() {
        //for
        val commandPrompts = mutableListOf(
            "C 1",
            // arguments not numbers
            "C x 1",
            "C 1 x",
            //arguments lower than allowed
            "C -1 1",
            "C 1 -1",
            //arguments to high
            "C 91 1",
            "C 1 91",
            //finally draw canvas
            "C 5 3",
            "Q"
        )
        val testInteraction = TestInteraction(commandPrompts)
        val paintApp = Paint(testInteraction)

        val expectedErrors = listOf(
            "Canvas command needs 2 arguments",
            "Argument number 1 of value: x can't be converted to integer",
            "Argument number 2 of value: x can't be converted to integer",

            "Canvas width must be in range from 1 to ${Canvas.MAX_WIDTH}",
            "Canvas height must be in range from 1 to ${Canvas.MAX_HEIGHT}",

            "Canvas width must be in range from 1 to ${Canvas.MAX_WIDTH}",
            "Canvas height must be in range from 1 to ${Canvas.MAX_HEIGHT}",
        )

        val expectedDisplays = """
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

        testInteraction.errors.forEachIndexed { index, actual ->
            assertEquals(expectedErrors[index], actual)
        }

        assertEquals(expectedDisplays, testInteraction.displayedCanvas[0])

    }
}