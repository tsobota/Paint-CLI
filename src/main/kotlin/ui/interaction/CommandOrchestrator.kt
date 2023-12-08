package ui.interaction

import ui.canvas.Canvas
import ui.interaction.Constants.Companion.COMMAND_NAME_INDEX
import ui.interaction.command.AbstractCommandExecutor
import ui.interaction.command.Command
import ui.interaction.command.executors.*

class CommandOrchestrator(val interaction: Interaction) {

    var canvas = Canvas(0, 0, interaction)
    fun run(): Boolean {
        val input = input(interaction)
        val splitInput = normalize(input)
        val commandExecutor = direct(splitInput)

        val continueRun = commandExecutor.run(splitInput)

        if (commandExecutor is CanvasCommand) {
            canvas = commandExecutor.getNewCanvas()
        }
        return continueRun
    }

    private fun input(interaction: Interaction): String = interaction.promptCommand()
    private fun normalize(input: String): List<String> {
        val pattern = "\\s+".toRegex()
        val inputTrimmed = input.replace(pattern, " ")
            .trimEnd()
            .trimStart()

        return inputTrimmed.split(" ").toMutableList()
    }

    private fun direct(input: List<String>): AbstractCommandExecutor {

        val command = Command.byNameIgnoreCase(input[COMMAND_NAME_INDEX])

        return when (command) {
            Command.C -> CanvasCommand(interaction, canvas)
            Command.L -> LineCommand(interaction, canvas)
            Command.R -> RectangleCommand(interaction, canvas)
            Command.B -> BucketCommand(interaction, canvas)
            Command.Q -> QuitCommand(interaction, canvas)
            Command.UNKNOWN -> UnknownCommand(interaction, canvas)
        }
    }
}

