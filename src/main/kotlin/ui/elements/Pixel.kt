package ui.elements

class Pixel(private var color: String) : Colorable {
    override fun getColor(): String = color

    override fun setColor(color: String) {
        this.color = color
    }

    override fun toString(): String = color

}

