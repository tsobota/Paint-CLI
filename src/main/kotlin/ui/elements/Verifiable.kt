package ui.elements

interface Verifiable {
    fun canBeDraw(width: Int, height: Int): Boolean
}