package systemdesign.parkinglot.parkingslot

import systemdesign.parkinglot.vehicle.Vehicle
import systemdesign.parkinglot.vehicle.VehicleType

open class ParkingSpotManager constructor() {
    constructor(list: List<ParkingSpot>) : this()

}


class TwoWheelerParkingSpotManager : ParkingSpotManager() {

}

class FourWheelerParkingSpotManager : ParkingSpotManager() {
}


class ParkingSpotManagerFactory {

    fun getParkingManagerSpotOnBasisOfVehicleType(vehicle: Vehicle) {
        when (vehicle.vehicleType) {
            VehicleType.TWO_WHEELER -> TwoWheelerParkingSpotManager()
            VehicleType.FOUR_WHEELER -> FourWheelerParkingSpotManager()
        }
    }
}