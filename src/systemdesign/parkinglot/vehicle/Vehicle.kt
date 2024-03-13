package systemdesign.parkinglot.vehicle

data class Vehicle(val vehicleNumber: String, val vehicleType: VehicleType)

enum class VehicleType {
    TWO_WHEELER, FOUR_WHEELER
}