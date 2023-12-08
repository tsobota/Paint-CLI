package ui.interaction.command

import ui.canvas.Canvas
import ui.interaction.Constants.Companion.COMMAND_ARGUMENT_1_INDEX
import ui.interaction.Constants.Companion.COMMAND_ARGUMENT_2_INDEX
import ui.interaction.Constants.Companion.COMMAND_ARGUMENT_3_INDEX
import ui.interaction.Constants.Companion.COMMAND_ARGUMENT_4_INDEX
import ui.interaction.Interaction

abstract class AbstractCommandExecutor(val interaction: Interaction, val canvas: Canvas) : CommandExecutor {
    fun run(input: List<String>): Boolean {
        val (status, message) = verify(input)
        return when (status) {
            true -> execute(canvas, transform(input.toMutableList()))
            false -> interaction.displayError(message)
        }
    }

    override fun verify(input: List<String>): Pair<Boolean, String> {
        return when {
            canvas.width == 0 && canvas.height == 0 -> Pair(false, "Canvas not initialized")
            input.size < 5 -> Pair(false, "Input command needs 4 arguments")
            input[COMMAND_ARGUMENT_1_INDEX].toIntOrNull() == null -> Pair(
                false,
                "Argument number 1 of value: ${input[COMMAND_ARGUMENT_1_INDEX]} can't be converted to integer"
            )

            input[COMMAND_ARGUMENT_2_INDEX].toIntOrNull() == null -> Pair(
                false,
                "Argument number 2 of value: ${input[COMMAND_ARGUMENT_2_INDEX]} can't be converted to integer"
            )

            input[COMMAND_ARGUMENT_3_INDEX].toIntOrNull() == null -> Pair(
                false,
                "Argument number 3 of value: ${input[COMMAND_ARGUMENT_3_INDEX]} can't be converted to integer"
            )

            input[COMMAND_ARGUMENT_4_INDEX].toIntOrNull() == null -> Pair(
                false,
                "Argument number 4 of value: ${input[COMMAND_ARGUMENT_4_INDEX]} can't be converted to integer"
            )

            !(1..canvas.width).contains(input[COMMAND_ARGUMENT_1_INDEX].toInt()) -> Pair(
                false,
                "Argument number 1 of value: ${input[COMMAND_ARGUMENT_1_INDEX]} is not in canvas width range"
            )

            !(1..canvas.width).contains(input[COMMAND_ARGUMENT_3_INDEX].toInt()) -> Pair(
                false,
                "Argument number 3 of value: ${input[COMMAND_ARGUMENT_3_INDEX]} is not in canvas width range"
            )

            !(1..canvas.height).contains(input[COMMAND_ARGUMENT_2_INDEX].toInt()) -> Pair(
                false,
                "Argument number 2 of value: ${input[COMMAND_ARGUMENT_2_INDEX]} is not in canvas height range"
            )

            !(1..canvas.height).contains(input[COMMAND_ARGUMENT_4_INDEX].toInt()) -> Pair(
                false,
                "Argument number 4 of value: ${input[COMMAND_ARGUMENT_4_INDEX]} is not in canvas height range"
            )

            (input[1].toInt() == input[2].toInt())
                    && (input[3].toInt() == input[4].toInt())
                    && (input[2].toInt() == input[3].toInt()) -> Pair(false, "All arguments can't be the same")

            else -> Pair(true, "")
        }
    }

    override fun transform(input: MutableList<String>): List<String> {
        for (i in 1..<input.size)
            input[i] = transformToCoordinates(input[i])
        return input
    }

    protected fun transformToCoordinates(value: String): String = (value.toInt() - 1).toString()
}