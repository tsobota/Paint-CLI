package ui.interaction.command.executors

import ui.canvas.Canvas
import ui.interaction.Interaction
import ui.interaction.command.AbstractCommandExecutor

class QuitCommand(interaction: Interaction, canvas: Canvas) : AbstractCommandExecutor(interaction, canvas) {

    override fun verify(input: List<String>): Pair<Boolean, String> = Pair(true, "")

    override fun transform(input: MutableList<String>): List<String> = input

    override fun execute(target: Canvas, input: List<String>): Boolean = false
}