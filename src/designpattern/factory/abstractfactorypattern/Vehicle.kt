package designpattern.factory.abstractfactorypattern

interface Vehicle {
    fun average(): String
}

enum class VehicleType {
    LUXURYV1, LUXURYV2, LUXURYV3, ORDINARYV1, ORDINARYV2, ORDINARYV3
}