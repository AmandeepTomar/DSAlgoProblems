package designpattern.decoratorpattern

class ExtraCheese(private val basePizza: BasePizza) : ToppingDecorator() {
    override fun cost(): Int {
        return basePizza.cost() + 10
    }
}