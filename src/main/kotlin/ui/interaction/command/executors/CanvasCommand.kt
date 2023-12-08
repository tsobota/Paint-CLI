package ui.interaction.command.executors

import ui.canvas.Canvas
import ui.interaction.Constants.Companion.COMMAND_ARGUMENT_1_INDEX
import ui.interaction.Constants.Companion.COMMAND_ARGUMENT_2_INDEX
import ui.interaction.Interaction
import ui.interaction.command.AbstractCommandExecutor

class CanvasCommand(interaction: Interaction, canvas: Canvas) : AbstractCommandExecutor(interaction, canvas) {

    private var newCanvas: Canvas = canvas
    override fun verify(input: List<String>): Pair<Boolean, String> {
        return when {
            input.size < 3 -> Pair(false, "Canvas command needs 2 arguments")

            input[COMMAND_ARGUMENT_1_INDEX].toIntOrNull() == null -> Pair(
                false,
                "Argument number 1 of value: ${input[COMMAND_ARGUMENT_1_INDEX]} can't be converted to integer"
            )

            input[COMMAND_ARGUMENT_2_INDEX].toIntOrNull() == null -> Pair(
                false,
                "Argument number 2 of value: ${input[COMMAND_ARGUMENT_2_INDEX]} can't be converted to integer"
            )

            !(1..Canvas.MAX_WIDTH).contains(input[COMMAND_ARGUMENT_1_INDEX].toInt()) -> Pair(
                false,
                "Canvas width must be in range from 1 to ${Canvas.MAX_WIDTH}"
            )

            !(1..Canvas.MAX_HEIGHT).contains(input[COMMAND_ARGUMENT_2_INDEX].toInt()) -> Pair(
                false,
                "Canvas height must be in range from 1 to ${Canvas.MAX_HEIGHT}"
            )

            else -> Pair(true, "")
        }
    }

    override fun transform(input: MutableList<String>): List<String> = input

    override fun execute(target: Canvas, input: List<String>): Boolean {
        newCanvas =
            Canvas(input[COMMAND_ARGUMENT_2_INDEX].toInt(), input[COMMAND_ARGUMENT_1_INDEX].toInt(), interaction)
        newCanvas.printCanvas()
        return true
    }

    fun getNewCanvas(): Canvas = newCanvas
}