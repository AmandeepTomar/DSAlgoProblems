package solidPrinciple


// L -> Liskov , sub class interchangeable to it super class without break functionality.

// here is the normal implementation.
open class Car {
    fun getCarTypeWidth() = 18
}

class RacingCar : Car() {
    fun getTyreWidth() = 31
}

fun main() {
    val list = mutableListOf(RacingCar(), Car())
    list.forEach { car ->
        when (car) {
            is RacingCar -> {
                car.getTyreWidth()
            }

            is Car -> {
                car.getCarTypeWidth()
            }
        }
    }
    // this implementation have issue like Racing car is not interchangeable with car object.
    // to fix this we will create an interface that will be implemented by both class so both can interchangeable.
    // As show in for loop we need to put the check for each type of class. like Car ,RacingcAr , SportCar so on.

    // After solution

    val newList = mutableListOf(NewCar(), NewRacingCar(), NewSportCar())

    newList.forEach {
        println(it.getVehicleTypeWidth())
    }
}

// Solution of this problem
interface Vehicle {

    fun getVehicleTypeWidth(): Int
}

class NewCar : Vehicle {
    override fun getVehicleTypeWidth(): Int {
        return this.getCarTypeWidth()
    }

    private fun getCarTypeWidth() = 32

}

class NewRacingCar : Vehicle {

    override fun getVehicleTypeWidth(): Int {
        return this.getTyreWidth()
    }

    private fun getTyreWidth() = 32
}

class NewSportCar : Vehicle {

    override fun getVehicleTypeWidth(): Int {
        return this.getSportsCarTyreWidth()
    }

    private fun getSportsCarTyreWidth() = 28
}