package designpattern.strategyPattern

fun main() {

    val vehicle = SportVehicle()
    vehicle.drive()

    val offRoadVehicle = OffRoadVehicle()
    offRoadVehicle.drive()
}