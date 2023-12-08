package ui.interaction.command.executors

import ui.canvas.Canvas
import ui.elements.rectangle.RectangleType
import ui.elements.rectangle.StandardRectangleFactory
import ui.interaction.Constants.Companion.COMMAND_ARGUMENT_1_INDEX
import ui.interaction.Constants.Companion.COMMAND_ARGUMENT_2_INDEX
import ui.interaction.Constants.Companion.COMMAND_ARGUMENT_3_INDEX
import ui.interaction.Constants.Companion.COMMAND_ARGUMENT_4_INDEX
import ui.interaction.Interaction
import ui.interaction.command.AbstractCommandExecutor

class RectangleCommand(interaction: Interaction, canvas: Canvas) : AbstractCommandExecutor(interaction, canvas) {

    companion object {
        val RECTANGLE_FACTORY = StandardRectangleFactory()
    }

    override fun execute(target: Canvas, input: List<String>): Boolean {
        val rectangle = RECTANGLE_FACTORY.createBasedOnType(
            RectangleType.HOLED,
            input[COMMAND_ARGUMENT_1_INDEX].toInt(),
            input[COMMAND_ARGUMENT_2_INDEX].toInt(),
            input[COMMAND_ARGUMENT_3_INDEX].toInt(),
            input[COMMAND_ARGUMENT_4_INDEX].toInt(),
        )
        target.draw(rectangle)
        target.printCanvas()
        return true
    }
}