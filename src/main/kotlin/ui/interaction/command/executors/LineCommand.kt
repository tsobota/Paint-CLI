package ui.interaction.command.executors

import ui.canvas.Canvas
import ui.elements.line.StraightLineFactory
import ui.interaction.Constants.Companion.COMMAND_ARGUMENT_1_INDEX
import ui.interaction.Constants.Companion.COMMAND_ARGUMENT_2_INDEX
import ui.interaction.Constants.Companion.COMMAND_ARGUMENT_3_INDEX
import ui.interaction.Constants.Companion.COMMAND_ARGUMENT_4_INDEX
import ui.interaction.Interaction
import ui.interaction.command.AbstractCommandExecutor

class LineCommand(interaction: Interaction, canvas: Canvas) : AbstractCommandExecutor(interaction, canvas) {

    companion object {
        val LINE_FACTORY: StraightLineFactory = StraightLineFactory()
    }

    override fun verify(input: List<String>): Pair<Boolean, String> {
        val verify = super.verify(input)
        if (!verify.first) {
            return verify
        }
        return when {
            (input[COMMAND_ARGUMENT_1_INDEX].toInt() != input[COMMAND_ARGUMENT_3_INDEX].toInt()) &&
                    (input[COMMAND_ARGUMENT_2_INDEX].toInt() != input[COMMAND_ARGUMENT_4_INDEX].toInt()) -> Pair(
                false,
                "Lines needs to be horizontal or vertical"
            )

            else -> Pair(true, "")
        }
    }

    override fun execute(target: Canvas, input: List<String>): Boolean {
        val line = LINE_FACTORY.createBasedOnCoordinates(
            input[COMMAND_ARGUMENT_1_INDEX].toInt(),
            input[COMMAND_ARGUMENT_2_INDEX].toInt(),
            input[COMMAND_ARGUMENT_3_INDEX].toInt(),
            input[COMMAND_ARGUMENT_4_INDEX].toInt(),
        )

        target.draw(line)
        target.printCanvas()
        return true
    }

}