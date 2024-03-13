## Car Rental Zoom car System Design

### Flows

1. Search
    1. User -> Search -> List of Stores on the basis of locations -> Store has List of Vehicle. -> Reservation -> Booked
       and picked car.
2. Reservation
3. Submission

### Requirements

1. We have users List of stores
2. We have pick stores from list of stores on the basis of location , like if we have location Delhi , Banglore , pune
   etc.
3. Every store has a list of vehicles -> Vehicle have types (CAR , BIKE etc ) so Vehicle should be scalable if need to
   add more vehicle type in future we can add.
4. filter capability on the basis of CC, Seater , type and all.
5. Reservation process start 
   1. Select a vehicle -> Reservation process start
   2. Bill  Generate 
   3. Payment 
   4. take the vehicle 
   5. Complete the reservation after submit the vehicle to store. 

### Entity / Objects 
1. User 
2. Store 
3. Location 
4. vehicle -> Vehicle Type Enum.
5. Reservation
6. Vehicle Cost computation strategy
7. Bill 
8. Payment

```java

import designpattern.strategyPattern.Vehicle;
import systemdesign.parkinglot.vehicle.VehicleType;

import javax.xml.stream.Location;
import java.util.List;

// Create the Vehicle Objec 
class vehicle {
    int id;
    String vehicleNo;
    VehicleType vehicleType;
    long kmDriven;
    float average;
    long cc;
    Date manufacturingDate;
    int dailyCost;
    int hourlyCost;
    int noOfSeat;
    VehicleStatus status;


    static enum VehicleType {
        CAR, BIKE
    }

    static enum VehicleStatus {
        ACTIVE, INACTIVE
    }
}

// No we have scalable vehicle like 

class CAR extends Vehicle {
    // its like cost we can specific  
}

class Bike extends Vehicle {
    // its like cost we can specific  
}

class VehicleInventoryMgmt {
    List<Vehicle> vehicles;

    // CURD

    List<Vehicle> getVehicles(FilterType filterType) {
        return vehicles.stream().filter(it.vehicleTyep = filterType);
    }
}

// if new type added in future than we can add inventory respectively to the vehicle type 
// IS-A relation ship with VehicleInventory
class CarVehicleInventoryMgmt extends VehicleInventoryMgmt {

}

// IS-A relation ship with VehicleInventory
class BikeVehicleInventoryMgmt extends VehicleInventoryMgmt {

}

// =============== vehicle completed ===============

// We have search stores , that is list of stores its basis on location and vehicle is attached to store
// Store has a VehicleInventory 
// VehicleInventory has Vehicles
// Store has VehicleInventory , Locations , Reservation,
class Store {
    long storeId;
    VehicleInventoryMgmt vehicleInventoryMgmt;
    Location location;
    List<Reservation> reservationList;


    // CRUD

    void setVehicles(List<Vehicle> vehicleList) {
        vehicleInventoryMgmt = new VehicleInventoryMgmt(vehicleList);
    }

    List<Vehicle> getVehicle(VehicleType vehicleType) {
        vehicleInventoryMgmt.getVehicles(vehicleType);
    }


    void completeReservation(long reservationID) {
        // complete reservation and set reservationStatus to completed.
    }
}


// Location 

class Location {
    String city;
    String name;
    String state;
    String zip;
}

// Reservation 
// Reservation has vehicle , user , location , reservationstatus
// we can use the strategy pattern for the ReservationType 
class Reservation {
    String reservationID;
    User user;
    Vehicle vehicle;
    Date bookingDate;
    Date bookedFrom;
    Date bookedTill;
    Long fromTimeStamp;
    Long toTimeStamp;
    Location pickupLocation;
    Location dropLocation;
    ReservationStatus reservationStatus;
    ReservationType reservationType;


    static enum ReservationStatus {
        SCHEDULED, INPROGRESS, COMPLETED, CANCELLED
    }

    static enum ReservationType {
        DAILY, HOURLY
    }


}


// User 
// we can discuss the user location is matter or not. 
// Driving licence should be valid
class User {
    long id;
    String dlNo;
    String userName;
    String email;
    String phoneNo;

    // CRUD
}


// Bill generate angst a reservation 
class Bill {
    Reservation reservation;
    boolean isPaid;
    double totalBillAbout;
}

class Payment {
    Bill bill;

    void doPayment() {
        // here update the status.
    }
}

class CashPayment extends Payment {

}

class OnlinePayment extends Payment {

}

// VehicleRentalSystem
// VehicleRentalSystem has list of stores and list of vehicle 
class VehicleRentalSystem {
    List<User> userList;
    List<Stores> storesList;


    public Store getStore(Location location) {
        return storesList.stream().filter {
            it.city = location.city
        }.first();
    }


    // support CRUD on stores and user
}


public static void main(String[] args) {

    List<User> userList = addUsers();
    List<Vehicle> vehicleList = addVehicles();
    List<Stores> storesList = addStores();

    VehicleRentalSystem vehicleRentalSystem = new VehicleRentalSystem(userList, storesList);
    User user = userList.get(0);
    Location location = new Location();
    Store store = vehicleRentalSystem.getStore(location);

    List<Vehicle> storeVehicleList = store.getVehicle(Vehicle.VehicleType.CAR);

    Reservation reservation = store.createReservation(storeVehicleList.get(o), user);

    Bill bill = new Bill(reservation);

    Payment payment = new Payment(bill);
    payment.doPayment();

    store.completeReservation(reservation.reservationID);

}




```
