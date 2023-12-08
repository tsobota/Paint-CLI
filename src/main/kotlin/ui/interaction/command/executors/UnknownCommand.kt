package ui.interaction.command.executors

import ui.canvas.Canvas
import ui.interaction.Interaction
import ui.interaction.command.AbstractCommandExecutor

class UnknownCommand(interaction: Interaction, canvas: Canvas) : AbstractCommandExecutor(interaction, canvas) {

    override fun verify(input: List<String>): Pair<Boolean, String> =
        Pair(false, "Command '${input.joinToString(" ")}' is unknown")

    override fun transform(input: MutableList<String>): List<String> = input

    override fun execute(target: Canvas, input: List<String>): Boolean = true
}