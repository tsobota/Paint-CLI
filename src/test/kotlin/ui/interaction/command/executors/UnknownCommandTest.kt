package ui.interaction.command.executors

import Paint
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test
import ui.interaction.TestInteraction

class UnknownCommandTest {

    @Test
    fun testMultipleWrongCommands() {
        //for
        val commandPrompts = mutableListOf(
            "C 5 3",
            "unknown test command 1",
            // additional whitespaces are producing correct command
            "      L     1      1            1    3    ",
            "unknown test command 2",
            //case insensitivity
            " l   5   1    5   3",
            "unknown test command 3",
            "l 1 2 5 2",
            "Q"
        )
        val testInteraction = TestInteraction(commandPrompts)
        val paintApp = Paint(testInteraction)

        val expectedErrors = listOf(
            "Command 'unknown test command 1' is unknown",
            "Command 'unknown test command 2' is unknown",
            "Command 'unknown test command 3' is unknown",
        )

        val expectedDisplays = """
            -------
            |X   X|
            |XXXXX|
            |X   X|
            -------
        """.trimIndent()

        //when
        paintApp.run()

        //then
        assertTrue { testInteraction.commandPrompts.isEmpty() }

        testInteraction.errors.forEachIndexed { index, actual ->
            assertEquals(expectedErrors[index], actual)
        }

        assertEquals(expectedDisplays, testInteraction.displayedCanvas[3])

    }
}