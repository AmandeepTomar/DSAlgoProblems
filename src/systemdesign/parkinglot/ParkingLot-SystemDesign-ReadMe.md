
## System Design Parking lot design 

#### Requirements
- Vehicle In -> Entry -> Ticket -> ParkingSpot -> Exit(Payment , Ticket Collect ) -> Vehicle Out 
1. How Many entrances we have?
   1. One Entrance and One Exit. 
2. Parking Spot
   1. Types of parking spot 
      1. TwoWheeler and FourWheeler.
   2. We can have a parking spot that is near to entry gate 
   3. We can have a parking spot that is near to elevator.
   4. or near to both. 
3. Payment 
   3. Payment Strategy 
      1. Hourly 
      2. Min
      3. Mix
4. Also asked for floors


#### Objects Required 
1. Vehicle
    - VehicleNo 
    - VehicleType
2. Ticket
    - EntryTime
    - parkingSpot
    - 
3. Entrance gate
   - findParkingSpace()-> updateparkingSpace()
   - Generate ticket.
4. Parking Spot (different type of spots , 2Wheeler , 4Wheeler) --> parkingSpotManager , 2WparkingSpotManager, 4WparkingSpotManager
   - parking spot id 
   - isEmpty 
   - Parked vehicle 
   - cost 
   - Vehicle Type 
5. Exit Gate
    - cost calculation 
    - payment received 
    - update parking spot
6. Payment (Payment Strategy)

#### LLD (Low Level Design)
- Top to Bottom 
- Bottom to Top

We will using Bottom to Top approach. 

1. We will create the parking Spot that one is the small entity

```java
import systemdesign.parkinglot.Parking;
import systemdesign.parkinglot.Ticket;

import java.util.List;

class ParkingSpot {
    int id;
    boolean isEmpty;
    Vehicle parkedVehicle;
    int price;

    void parkedVehicle(Vehicle vehicle) {
        this.parkedVehicle = vehicle;
        isEmpty = false;
    }

    void removeVehicle() {
        this.parkedVehicle = null;
        isEmpty = true;
    }
}

// Suppose we have 200 for TW and 400 for 4Wheeler 

// this one is extendable 
class TwoWheelerSpot extends ParkingSpot {

    // implement cost. 
}


class FourWheelerSpot extends ParkingSpot {
    // implement cost. 
}

// Now we have parking Spot manager that manage the spot , it has a list of parking spot 

class ParkingSpotManager {
    List<parkingSpot> parkingSpace;

    public ParkingSpotManger(List<parkingSpot> parkingSpace) {
        list = list;
    }

    void findSpace(ParkingStrategy defaultparkingStrategy);

    void addParkingSpace();

    void removeParkingSpace();

    void parkedVehicle();

    void removeVehicle(Ticket ticket);
}

// we have a is-A relation with TwoWheelerManager and FourWheelerManager 

class TwoWheelerManager extends ParkingSpotManager {
    // list of twoWheelerSpot
    public TwoWheelerManager(List<TwoWheelerSpot> twowheelerList) {
        super(list);
    }
}

class FourWheelerManager extends ParkingSpotManager {
    // list of FourWheelerSpot 
    public FourWheelerManager(List<FourWheelerSpot> fourwheelerList) {
        super(list);
    }
}

// we have create the parking Strategy 
abstract class ParkingStrategy {
    abstract fidSpace();
}

class NearestParkingStrategy extends ParkingStrategy {

    void findSpace() {

    }
}

class NearToElivatorParkingStrategy extends ParkingStrategy {
    void findSpace() {

    }
}

// We required Vehicle Objec 
// Vehicle has a vehicle type 

class Vehicle {
    String vehicleNo;
    VehicleTyep vehicleType;
}

enum VehicleType {
    TWOWHEELER,
    FOURWHEELER
}

// Now we required a Ticket 

class Ticket {
    long ticketId;
    long entryTime;
    Vehicel vehicle;
    ParkingSlot spotType;
}

// Now we are creating Entrance Gate
class EntranceGate {

    ParkingManagerFactoryPattern parkingSpoFactory;
    ParkingSpotmanager parkingSpotmanager;
    Ticket ticket;

    void findParkingSpace() {
        parkingSpotmanager.findSpace(list, strategy, entrancegFateNo);
    }

    void bookSpot(Vehicle vehicle);

    void generateTicket(Vehicle vehicle);
}

// Now we required parking manager , so we have parkingmanagerfactory.getVehicleType(vehicleType)
// 
class ParkingManagerFactoryPattern {
    ParkingSpotManager getParkingSpotManager(VehicleType vehicleType) {
        if (vehicleType == VehicleType.TWOWHEELER) {
            return new TwoWheelerManager();
        } else {
            return new FourWheelerManager();
        }
    }
}


// Cost computation strategy 
abstract class PricingStrategy {
    int cost(Ticket ticket);
}

class DefaultPricingStrategy extends PricingStrategy {
    int cost(Ticket ticket) {

    }
}

class HourlyPricingStrategy extends PricingStrategy {


    int cost(Ticket ticket) {

    }
}

class MinutePricingStrategy extends PricingStrategy {
    int cost() {

    }
}

class CostComputationStrategy {
    PricingStrategy pricingStrategy;
    Ticket ticket;

    int calculate() {
        pricingStrategy.cost(ticket);
    }
}

class TwoWheelerCostStrategy extends CostStrategy {
    PricingStrategy pricingStrategy;
    Ticket ticket;

    int calculate() {
        pricingStrategy.cost(ticket);
    }
}

class FourWheelerCostStrategy extends CostStrategy {
    PricingStrategy pricingStrategy;
    Ticket ticket;

    int calculate() {
        pricingStrategy.cost(ticket);
    }
}


class CostComputationFactory {

    CostComputationStrategy getCostComputationByVehicle(Vehicle vehicle) {
        if (vehicleType == VehicleType.TWOWHEELER) {
            return new TwoWheelerCostStrategy();
        } else {
            return new FourWheelerCostStrategy();
        }
    }
}

class Payment{

    boolean isPaymentSuccess(){

    }
}

class CreditCardPayment{
    boolean isPaymentSuccess(){

    }
}

class CashPayment{
    boolean isPaymentSuccess(){

    }
}

class UPIPayment{
    
   boolean isPaymentSuccess(){
       
   }
  
}

// whe have payment factory class here 
/


// Exit gate have ticket 

class ExitGate {
    Ticket ticket;
    CostComputationStrategy costComputationStrategy;
    Payment payment;
    ParkingSpotManager parkingSpotManager;
    
    
    void  priceCalculation(){
        costComputationStrategy.calculate();
    }

    void payment(){
        payment.isPaymentSuccess();
    }
    
    void removeVehicle(){
        parkingSpotManager.removeVehicle(ticket);
    }
}


```


