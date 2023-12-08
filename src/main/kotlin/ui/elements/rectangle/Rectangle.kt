package ui.elements.rectangle

import ui.elements.Colorable
import ui.elements.Drawable
import ui.elements.Verifiable

abstract class Rectangle(private var color: String = "X") : Colorable, Drawable, Verifiable {

    override fun getColor(): String = color

    override fun setColor(color: String) {
        this.color = color
    }
}