package ui.interaction.command

import ui.canvas.Canvas

interface CommandExecutor {
    fun verify(input: List<String>): Pair<Boolean, String>
    fun transform(input: MutableList<String>): List<String>
    fun execute(target: Canvas, input: List<String>): Boolean
}