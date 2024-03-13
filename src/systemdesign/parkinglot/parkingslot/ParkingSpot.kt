package systemdesign.parkinglot.parkingslot

import systemdesign.parkinglot.ticket.Ticket
import systemdesign.parkinglot.vehicle.Vehicle


interface ParkingVehicle {
    fun parkVehicle(vehicle: Vehicle)

    fun unParkVehicle(ticket: Ticket)
}

open class ParkingSpot constructor(private val parkingSlotId: Long) : ParkingVehicle {
    var parkedVehicle: Vehicle? = null
    var isEmpty: Boolean = true
    override fun parkVehicle(vehicle: Vehicle) {
        this.parkedVehicle = vehicle
        isEmpty = false
    }

    override fun unParkVehicle(ticket: Ticket) {
        parkedVehicle = null
        isEmpty = true
    }

    fun getIsEmpty() = isEmpty

    open fun cost(): Long {
        return 10
    }
}


class TwoWheelerParkingSpot constructor(parkingSpotId: Long) : ParkingSpot(parkingSpotId) {

    override fun cost(): Long {
        return 10;
    }

}

class FourWheelerParkingSpot constructor(parkingSpotId: Long) : ParkingSpot(parkingSpotId) {
    override fun cost(): Long {
        return 20;
    }
}


