package designpattern.factory.abstractfactorypattern

class OrdinaryFactory : VehicleFactory {
    override fun getVehicle(vehicleType: VehicleType): Vehicle {
        return when (vehicleType) {
            VehicleType.ORDINARYV1 -> Ordinaryv1()
            VehicleType.ORDINARYV2 -> OrdinaryV2()
            VehicleType.ORDINARYV3 -> OrdinaryV3()
            else -> throw IllegalArgumentException("Not Suported")
        }
    }
}
