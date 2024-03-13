package designpattern.decoratorpattern

class Farmhouse : BasePizza() {
    override fun cost(): Int {
        return 200
    }
}