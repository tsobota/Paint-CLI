package ui.interaction.command.executors

import Paint
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test
import ui.interaction.TestInteraction

class RectangleCommandTest {
    @Test
    fun testMultipleWrongCommands() {
        //for
        val commandPrompts = mutableListOf(
            //draw before Canvas init
            "R 1 1 1 3",
            "C 5 3",
            // to short command
            "R 1",
            // arguments not numbers
            "R x 1 3 1",
            "R 1 x 3 1",
            "R 1 1 x 1",
            "R 1 1 3 x",
            //arguments lower than allowed
            "R -1 1 3 1",
            "R 1 -1 3 1",
            "R 1 1 -3 1",
            "R 1 1 3 -1",
            //arguments to high
            "R 91 1 3 1",
            "R 1 91 3 1",
            "R 1 1 93 1",
            "R 1 1 3 91",

            "R 1 1 1 1",
            //finally draw rectangle
            "R 1 1 3 3",
            "Q"
        )
        val testInteraction = TestInteraction(commandPrompts)
        val paintApp = Paint(testInteraction)

        val expectedErrors = listOf(
            "Canvas not initialized",
            "Input command needs 4 arguments",
            "Argument number 1 of value: x can't be converted to integer",
            "Argument number 2 of value: x can't be converted to integer",
            "Argument number 3 of value: x can't be converted to integer",
            "Argument number 4 of value: x can't be converted to integer",
            "Argument number 1 of value: -1 is not in canvas width range",
            "Argument number 2 of value: -1 is not in canvas height range",
            "Argument number 3 of value: -3 is not in canvas width range",
            "Argument number 4 of value: -1 is not in canvas height range",
            "Argument number 1 of value: 91 is not in canvas width range",
            "Argument number 2 of value: 91 is not in canvas height range",
            "Argument number 3 of value: 93 is not in canvas width range",
            "Argument number 4 of value: 91 is not in canvas height range",
            "All arguments can't be the same"
        )

        val expectedDisplays = """
            -------
            |XXX  |
            |X X  |
            |XXX  |
            -------
        """.trimIndent()

        //when
        paintApp.run()

        //then
        assertTrue { testInteraction.commandPrompts.isEmpty() }

        testInteraction.errors.forEachIndexed { index, actual ->
            assertEquals(expectedErrors[index], actual)
        }

        assertEquals(expectedDisplays, testInteraction.displayedCanvas[1])

    }
}