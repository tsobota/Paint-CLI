package ui.elements

import Paint
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import ui.interaction.TestInteraction

class MultipleElementsTest {
    @Test
    fun testMultipleElementsCreation() {
        //for
        val commandPrompts = mutableListOf("C 20 4", "L 1 2 6 2", "L 6 3 6 4", "R 14 1 18 3", "B 10 3 o", "Q")
        val testInteraction = TestInteraction(commandPrompts)
        val paintApp = Paint(testInteraction)

        val expected = listOf(
            """
                ----------------------
                |                    |
                |                    |
                |                    |
                |                    |
                ----------------------
            """.trimIndent(),
            """
                ----------------------
                |                    |
                |XXXXXX              |
                |                    |
                |                    |
                ----------------------
            """.trimIndent(),
            """
                ----------------------
                |                    |
                |XXXXXX              |
                |     X              |
                |     X              |
                ----------------------
            """.trimIndent(),
            """
                 ----------------------
                 |             XXXXX  |
                 |XXXXXX       X   X  |
                 |     X       XXXXX  |
                 |     X              |
                 ----------------------
            """.trimIndent(),
            """
                ----------------------
                |oooooooooooooXXXXXoo|
                |XXXXXXoooooooX   Xoo|
                |     XoooooooXXXXXoo|
                |     Xoooooooooooooo|
                ----------------------
            """.trimIndent()
        )

        //when
        paintApp.run()

        //then
        Assertions.assertTrue { testInteraction.commandPrompts.isEmpty() }

        expected.forEachIndexed { index, s -> Assertions.assertEquals(s, testInteraction.displayedCanvas[index]) }

    }
}