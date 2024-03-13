package designpattern.factory.abstractfactorypattern

interface VehicleFactory {
    fun getVehicle(vehicleType: VehicleType): Vehicle

}

enum class VehicleTypeFactory {
    LUXURY_FACTORY, ORDINARY_FACTORY
}