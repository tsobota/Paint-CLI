package ui.interaction

interface Interaction {
    fun promptCommand(): String
    fun displayError(message: String): Boolean
    fun displayCanvas(canvas: String)
}