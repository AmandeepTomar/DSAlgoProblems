package designpattern.strategyPattern

import designpattern.strategyPattern.strategy.SportsStrategy

class SportVehicle() : Vehicle(SportsStrategy()) {
}