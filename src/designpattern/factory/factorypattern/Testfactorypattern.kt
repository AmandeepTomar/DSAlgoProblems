package designpattern.factory.factorypattern

fun main() {

    val shapeFactory = ShapeFactory().getShape(ShapeType.OVAL)
    shapeFactory.draw()
}