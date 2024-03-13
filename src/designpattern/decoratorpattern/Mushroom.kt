package designpattern.decoratorpattern

class Mushroom(private val basePizza: BasePizza) : ToppingDecorator() {
    override fun cost(): Int {
        return basePizza.cost() + 20
    }
}