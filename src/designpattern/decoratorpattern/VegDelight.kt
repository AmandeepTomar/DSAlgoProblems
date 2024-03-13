package designpattern.decoratorpattern

class VegDelight : BasePizza() {
    override fun cost(): Int {
        return 200
    }
}