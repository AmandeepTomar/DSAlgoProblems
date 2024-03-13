package designpattern.factory.abstractfactorypattern

import kotlin.math.abs

fun main() {

    val abstractFactoryPattern = AbstractFactoryPattern()
    val ordinary = abstractFactoryPattern.getVehicleType(VehicleTypeFactory.ORDINARY_FACTORY)
    val luxury = abstractFactoryPattern.getVehicleType(VehicleTypeFactory.LUXURY_FACTORY)

    println(ordinary.getVehicle(VehicleType.ORDINARYV2).average())
    println(ordinary.getVehicle(VehicleType.ORDINARYV1).average())

    println(luxury.getVehicle(VehicleType.LUXURYV1).average())
    println(luxury.getVehicle(VehicleType.LUXURYV2).average())


}