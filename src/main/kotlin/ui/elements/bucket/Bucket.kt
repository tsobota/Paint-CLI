package ui.elements.bucket

import ui.elements.Colorable
import ui.elements.Drawable
import ui.elements.Pixel
import ui.elements.Verifiable

class Bucket(private var x: Int, private var y: Int, private var color: String) : Colorable, Drawable, Verifiable {

    override fun getColor(): String = color

    override fun setColor(color: String) {
        this.color = color
    }

    override fun draw(target: List<List<Pixel>>) {
        draw(target, x, y)

    }

    private fun draw(target: List<List<Pixel>>, x: Int, y: Int) {

        if (x in 0 until target.first().size &&
            y in 0 until target.size &&
            target[y][x].getColor() == " "
        ) {
            target[y][x].setColor(color)

            draw(target, x + 1, y)
            draw(target, x - 1, y)
            draw(target, x, y + 1)
            draw(target, x, y - 1)
        }

    }

    override fun canBeDraw(width: Int, height: Int): Boolean {
        return when {
            width <= x || height <= y -> false
            x < 0 || y < 0 -> false
            else -> true
        }
    }
}