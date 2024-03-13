package designpattern.factory.factorypattern

class ShapeFactory {
    fun getShape(shaType: ShapeType): Shape {
        return when (shaType) {
            ShapeType.CIRCLE -> Circle()
            ShapeType.OVAL -> Oval()
            ShapeType.SQUARE -> Square()
            ShapeType.RECTANGEL -> Rectangle()
        }
    }
}

enum class ShapeType {
    CIRCLE, RECTANGEL, OVAL, SQUARE
}