package solidPrinciple

// S-> Single Responsibility

class Square{

    fun calculateArea(side:Int):Int=side*side

    fun calculatePerimeter(side:Int)= 4*side

    fun renderSquare() =  println("Render Square")

    fun renderLargeSquare() =  println("Render Large Square")

}

// we have problem in this class is it have two responsibility ,
// 1. calculation on square
// 2. render the square so we need to split it.  coze render is part of UI.

class UpdatedSquare {
    fun calculateArea(side:Int):Int=side*side

    fun calculatePerimeter(side:Int)= 4*side
}

class SquareRenderUi{
    fun renderSquare() =  println("Render Square")

    fun renderLargeSquare() =  println("Render Large Square")
}

// Another Example of Marker , Invoice class , InvoicePrinter and InvoiceSaveTODB class .
// As first Invoice class have all three responsibility
// 1. Calculate Price
// 2. Print Invoice
// 3. Save Invoice in DB
// After devide the responsibility in three class. so each class has exact one reason to change.