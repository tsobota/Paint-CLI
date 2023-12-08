package ui.elements.line

import ui.elements.Colorable
import ui.elements.Drawable
import ui.elements.Verifiable

abstract class Line(
    val x1: Int, val y1: Int, val x2: Int, val y2: Int,
    private var color: String = "X"
) : Colorable, Drawable, Verifiable {

    override fun getColor(): String = color

    override fun setColor(color: String) {
        this.color = color
    }

    override fun canBeDraw(width: Int, height: Int): Boolean {
        return when {
            width <= x1 || width <= x2 || height <= y1 || height <= y2 -> false
            x1 < 0 || x2 < 0 || y1 < 0 || y2 < 0 -> false
            else -> true
        }
    }
}