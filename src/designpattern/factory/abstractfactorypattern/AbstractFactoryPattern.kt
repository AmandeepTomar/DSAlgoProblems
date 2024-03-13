package designpattern.factory.abstractfactorypattern

class AbstractFactoryPattern {

    fun getVehicleType(vehicleTypeFactory: VehicleTypeFactory): VehicleFactory {
        return when (vehicleTypeFactory) {
            VehicleTypeFactory.ORDINARY_FACTORY -> OrdinaryFactory()
            VehicleTypeFactory.LUXURY_FACTORY -> LuxuryFactory()
        }
    }
}