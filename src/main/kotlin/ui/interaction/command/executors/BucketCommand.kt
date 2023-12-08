package ui.interaction.command.executors

import ui.canvas.Canvas
import ui.elements.bucket.Bucket
import ui.interaction.Constants.Companion.COMMAND_ARGUMENT_1_INDEX
import ui.interaction.Constants.Companion.COMMAND_ARGUMENT_2_INDEX
import ui.interaction.Constants.Companion.COMMAND_ARGUMENT_3_INDEX
import ui.interaction.Interaction
import ui.interaction.command.AbstractCommandExecutor

class BucketCommand(interaction: Interaction, canvas: Canvas) : AbstractCommandExecutor(interaction, canvas) {
    override fun verify(input: List<String>): Pair<Boolean, String> {
        return when {
            canvas.width == 0 && canvas.height == 0 -> Pair(false, "Canvas not initialized")
            input.size < 4 -> Pair(false, "Input command needs 3 arguments")
            input[COMMAND_ARGUMENT_1_INDEX].toIntOrNull() == null -> Pair(
                false,
                "Argument number 1 of value: ${input[COMMAND_ARGUMENT_1_INDEX]} can't be converted to integer"
            )

            input[COMMAND_ARGUMENT_2_INDEX].toIntOrNull() == null -> Pair(
                false,
                "Argument number 2 of value: ${input[COMMAND_ARGUMENT_2_INDEX]} can't be converted to integer"
            )

            !(1..canvas.width).contains(input[COMMAND_ARGUMENT_1_INDEX].toInt()) -> Pair(
                false,
                "Argument number 1 of value: ${input[COMMAND_ARGUMENT_1_INDEX]} is not in canvas width range"
            )

            !(1..canvas.width).contains(input[COMMAND_ARGUMENT_2_INDEX].toInt()) -> Pair(
                false,
                "Argument number 2 of value: ${input[COMMAND_ARGUMENT_2_INDEX]} is not in canvas height range"
            )

            else -> Pair(true, "")
        }
    }

    override fun transform(input: MutableList<String>): List<String> {
        for (i in 1 until input.size - 1) // last argument is any character not coordinate
            input[i] = transformToCoordinates(input[i])
        return input
    }

    override fun execute(target: Canvas, input: List<String>): Boolean {
        val bucket = Bucket(
            input[COMMAND_ARGUMENT_1_INDEX].toInt(),
            input[COMMAND_ARGUMENT_2_INDEX].toInt(),
            input[COMMAND_ARGUMENT_3_INDEX]
        )
        target.draw(bucket)
        target.printCanvas()
        return true
    }
}