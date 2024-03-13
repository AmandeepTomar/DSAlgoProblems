package designpattern.factory.abstractfactorypattern

import kotlin.jvm.Throws

class LuxuryFactory : VehicleFactory {
    @Throws(IllegalArgumentException::class)
    override fun getVehicle(vehicleType: VehicleType): Vehicle {
        return when (vehicleType) {
            VehicleType.LUXURYV1 -> Luxuryv1()
            VehicleType.LUXURYV2 -> LuxuryV2()
            VehicleType.LUXURYV3 -> LuxuryV3()
            else -> throw IllegalArgumentException("Not Supported")
        }
    }
}

