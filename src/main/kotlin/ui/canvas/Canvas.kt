package ui.canvas

import ui.elements.Drawable
import ui.elements.Pixel
import ui.elements.borders.HorizontalBorder
import ui.elements.borders.VerticalBorder
import ui.interaction.Interaction

data class Canvas(val height: Int, val width: Int, private val interaction: Interaction) {
    private val topBorder: HorizontalBorder = HorizontalBorder()
    private val bottomBorder: HorizontalBorder = HorizontalBorder()

    private val leftBorder: VerticalBorder = VerticalBorder()
    private val rightBorder: VerticalBorder = VerticalBorder()

    private val pixels = List(height) { List(width) { Pixel(" ") } }

    companion object {
        val MAX_WIDTH = 30
        val MAX_HEIGHT = 10
    }

    fun printCanvas() {
        val stringBuilder = StringBuilder()

        //top border
        for (i in 0..<width + 2) {
            stringBuilder.append(topBorder.getColor())
        }
        stringBuilder.append("\n")

        //each line of pixels with border

        for (y in 0..<height) {
            stringBuilder.append(leftBorder.getColor())
            for (x in 0..<width) {
                stringBuilder.append(pixels[y][x].getColor())
            }
            stringBuilder.append(rightBorder.getColor())
            stringBuilder.append("\n")
        }

        for (i in 0..<width + 2) {
            stringBuilder.append(bottomBorder.getColor())
        }

        interaction.displayCanvas(stringBuilder.toString())
    }

    fun draw(figure: Drawable) {
        try {
            if (pixels.isEmpty())
                throw Exception("Canvas not initialized")
            figure.draw(pixels)
        } catch (e: Exception) {
            interaction.displayError(e.message ?: "Can't draw ${figure.javaClass}")
        }
    }
}