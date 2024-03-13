package designpattern.strategyPattern.strategy

import designpattern.strategyPattern.DriveStrategy

class XYZStrategy : DriveStrategy {
    override fun drive() {
        println("XYZ strategy")
    }
}