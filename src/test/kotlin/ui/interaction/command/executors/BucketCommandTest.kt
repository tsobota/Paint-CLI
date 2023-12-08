package ui.interaction.command.executors

import Paint
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test
import ui.interaction.TestInteraction

class BucketCommandTest {
    @Test
    fun testMultipleWrongCommands() {
        //for
        val commandPrompts = mutableListOf(
            //draw before Canvas init
            "B 1 1 c",
            "C 5 3",
            // to short command
            "B 1",
            // arguments not numbers
            "B x 1 c",
            "B 1 x c",
            //arguments lower than allowed
            "B -1 1 c",
            "B 1 -1 c",
            //arguments to high
            "B 91 1 c",
            "B 1 91 c",
            //finally draw bucket
            "B 1 2 c",
            "Q"
        )
        val testInteraction = TestInteraction(commandPrompts)
        val paintApp = Paint(testInteraction)

        val expectedErrors = listOf(
            "Canvas not initialized",
            "Input command needs 3 arguments",
            "Argument number 1 of value: x can't be converted to integer",
            "Argument number 2 of value: x can't be converted to integer",

            "Argument number 1 of value: -1 is not in canvas width range",
            "Argument number 2 of value: -1 is not in canvas height range",

            "Argument number 1 of value: 91 is not in canvas width range",
            "Argument number 2 of value: 91 is not in canvas height range",
        )

        val expectedDisplays = """
            -------
            |ccccc|
            |ccccc|
            |ccccc|
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