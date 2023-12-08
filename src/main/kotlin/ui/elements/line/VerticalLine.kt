package ui.elements.line

import ui.elements.Pixel

class VerticalLine(x1: Int, y1: Int, x2: Int, y2: Int) : Line(x1, y1, x2, y2) {
    override fun draw(target: List<List<Pixel>>) {
        val y1Copy = if (y1 <= y2) y1 else y2
        val y2Copy = if (y1 <= y2) y2 else y1

        when (canBeDraw(target.first().size, target.size)) {
            true -> for (y in y1Copy..y2Copy)
                target[y][x1].setColor(getColor())

            false -> throw Exception("Vertical line cannot be draw")
        }
    }
}