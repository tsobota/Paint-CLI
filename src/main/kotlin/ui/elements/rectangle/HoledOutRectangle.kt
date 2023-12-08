package ui.elements.rectangle

import ui.elements.Pixel
import ui.elements.line.LineFactory
import ui.elements.line.StraightLineFactory

class HoledOutRectangle(val x1: Int, val y1: Int, val x2: Int, val y2: Int) : Rectangle() {
    override fun draw(target: List<List<Pixel>>) {
        val straightLineFactory: LineFactory = StraightLineFactory()
        try {
            straightLineFactory.createBasedOnCoordinates(x1, y1, x2, y1).draw(target)
            straightLineFactory.createBasedOnCoordinates(x1, y1, x1, y2).draw(target)
            straightLineFactory.createBasedOnCoordinates(x2, y1, x2, y2).draw(target)
            straightLineFactory.createBasedOnCoordinates(x1, y2, x2, y2).draw(target)
        } catch (e: Exception) {
            throw Exception("Rectangle cannot be draw")
        }

    }

    override fun canBeDraw(width: Int, height: Int): Boolean {
        val straightLineFactory: LineFactory = StraightLineFactory()
        return straightLineFactory.createBasedOnCoordinates(x1, y1, x2, y1)
            .canBeDraw(width, height) &&
                straightLineFactory.createBasedOnCoordinates(x1, y1, x1, y2)
                    .canBeDraw(width, height) &&
                straightLineFactory.createBasedOnCoordinates(x2, y1, x2, y2)
                    .canBeDraw(width, height) &&
                straightLineFactory.createBasedOnCoordinates(x1, y2, x2, y2)
                    .canBeDraw(width, height)
    }
}