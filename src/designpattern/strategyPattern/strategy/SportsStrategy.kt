package designpattern.strategyPattern.strategy

import designpattern.strategyPattern.DriveStrategy

class SportsStrategy : DriveStrategy {
    override fun drive() {
        println("Sport Strategy")
    }
}