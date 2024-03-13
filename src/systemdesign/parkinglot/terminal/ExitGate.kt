package systemdesign.parkinglot.terminal

import systemdesign.parkinglot.parkingslot.ParkingSpotManager
import systemdesign.parkinglot.ticket.Ticket


internal class ExitGate {
    var ticket: Ticket? = null
   // var costComputationStrategy: CostComputationStrategy? = null
   // var payment: Payment? = null
    var parkingSpotManager: ParkingSpotManager? = null


    fun priceCalculation() {
       // costComputationStrategy.calculate()
    }

    fun payment() {
       // payment.isPaymentSuccess()
    }

    fun removeVehicle() {
      //  parkingSpotManager.removeVehicle(ticket)
    }
}