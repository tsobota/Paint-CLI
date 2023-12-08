package ui.interaction

class TestInteraction(val commandPrompts: MutableList<String>) : Interaction {

    val errors = ArrayDeque<String>()
    val displayedCanvas = ArrayDeque<String>()

    override fun promptCommand(): String {
        return commandPrompts.removeFirst()
    }

    override fun displayError(message: String): Boolean {
        errors.addLast(message)
        return true
    }

    override fun displayCanvas(canvas: String) {
        displayedCanvas.addLast(canvas)
    }
}