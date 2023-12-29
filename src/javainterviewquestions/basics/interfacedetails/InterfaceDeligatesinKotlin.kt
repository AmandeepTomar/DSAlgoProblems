package javainterviewquestions.basics.interfacedetails


interface Engine {
    fun start()
}

class PetrolEngine() : Engine {
    override fun start() {
        println("Start PetrolEngine")
    }
}

class DieselEngine() : Engine {
    override fun start() {
        println("Start DieselEngine")
    }
}

class ElectricEngine() : Engine {
    override fun start() {
        println("Start ElectricEngine")
    }
}

class Car(private val engine: Engine) : Engine by engine {

    fun drive() {
        println("Drive Car")
    }
}

fun main() {
    val petrolEngine = PetrolEngine()
    val dieselEngine = DieselEngine()
    val electricEngine = ElectricEngine()

   Car(petrolEngine).apply {
        start()
        drive()
    }

    Car(dieselEngine).also {
        it.start()
        it.drive()
    }

    Car(electricEngine).let {
        it.start()
        it.drive()
    }
}