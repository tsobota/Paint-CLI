package ui.elements.rectangle

interface RectangleFactory {
    fun createBasedOnType(type: RectangleType, x1: Int, y1: Int, x2: Int, y2: Int): Rectangle
}

class StandardRectangleFactory : RectangleFactory {
    override fun createBasedOnType(type: RectangleType, x1: Int, y1: Int, x2: Int, y2: Int): Rectangle {
        return when (type) {
            RectangleType.HOLED -> HoledOutRectangle(x1, y1, x2, y2)
            else -> throw Exception("Not implemented")
        }
    }
}