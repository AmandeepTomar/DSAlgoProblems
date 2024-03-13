package designpattern.strategyPattern.strategy

import designpattern.strategyPattern.DriveStrategy

class NormalStrategy : DriveStrategy {
    override fun drive() {
        println("Normal Drive Strategy")
    }
}