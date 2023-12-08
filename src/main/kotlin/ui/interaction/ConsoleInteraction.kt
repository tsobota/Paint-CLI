package ui.interaction

class ConsoleInteraction : Interaction {
    override fun promptCommand(): String {
        print("Enter command: ")
        return readln()
    }

    override fun displayError(message: String): Boolean {
        println(message)
        return true
    }

    override fun displayCanvas(canvas: String) {
        println(canvas)
    }
}