package designpattern.decoratorpattern

import java.lang.foreign.Addressable

fun main() {

    // create veg delight pizza
    val vegDelight = VegDelight()
    println(vegDelight.cost())

    // add mushroom
    val addedMushroom = Mushroom(vegDelight)
    println("=addedMushroom ${addedMushroom.cost()}")

    val addedExtraChese = ExtraCheese(addedMushroom)

    println("addedExtraChese ${addedExtraChese.cost()}")
}