package designpattern.strategyPattern

open class Vehicle constructor(private val driveStrategy: DriveStrategy) {
    open fun drive() {
        driveStrategy.drive()
    }
}