package ui.elements.line

interface LineFactory {
    fun createBasedOnCoordinates(x1: Int, y1: Int, x2: Int, y2: Int): Line
}

class StraightLineFactory : LineFactory {
    override fun createBasedOnCoordinates(x1: Int, y1: Int, x2: Int, y2: Int): Line {
        return when {
            x1 == x2 && y1 == y2 -> throw Exception("It's a point not a line")
            x1 == x2 && y1 != y2 -> VerticalLine(x1, y1, x2, y2)
            x1 != x2 && y1 == y2 -> HorizontalLine(x1, y1, x2, y2)
            else -> throw Exception("It's not a straight line")
        }
    }
}