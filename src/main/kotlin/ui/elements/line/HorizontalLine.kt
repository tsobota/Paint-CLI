package ui.elements.line

import ui.elements.Pixel

class HorizontalLine(x1: Int, y1: Int, x2: Int, y2: Int) : Line(x1, y1, x2, y2) {

    override fun draw(target: List<List<Pixel>>) {
        val x1Copy = if (x1 <= x2) x1 else x2
        val x2Copy = if (x1 <= x2) x2 else x1

        when (canBeDraw(target.first().size, target.size)) {
            true -> for (x in x1Copy..x2Copy)
                target[y1][x].setColor(getColor())

            false -> throw Exception("Horizontal line cannot be draw")
        }
    }


}