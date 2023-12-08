package ui.elements.borders

import ui.elements.Colorable

abstract class AbstractBorder(private var color: String) : Colorable {
    override fun getColor(): String = color

    override fun setColor(color: String) {
        this.color = color
    }
}