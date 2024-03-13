# Elevator LLD

## Flow

- We have N no of floor
- We have button , TOP , Bottom
- Elevator Go Lift and down
- How many lift should be consider
    - Lifts can be N
- Person enter a building and press external button,
- If we have more than one lift
    - Dispatch Lift
        - Lift one will work on odd
        - Lift two work on even
- When user press button so it should be Many algorithm to dispatch the link.
- Fixed floor
- Odd and even
- Minimum seek time

We have discussed Algorithm and Design

### Algorithm

- We have algorithm used ExternalDispatcher
    - OddEvenDispatcher
    - FixedFloorDispatcher
- We have algorithm in ElevatorControl
- SCAN that is also called Elevator algorithm.
    - Disadvantages of this algo is it will go in one direction and hit top and go back and reached bottom then go UP.
    - this will not return from the middle if have no request.
- LOOK - Algo
    - It is the more efficient version of the SCAN loop.
    - it will in ideal of go down of no request is in queue to server
    - **MinPriorityQueue** to serve the request in UP direction.
    - **MaxHeadPriorityQueue** to serve the request in DOWN direction.
    - **Queue** for Pending request
    - Same direction request will be added in priority queue if the requested floor is grater than current floor in case
      of UP and add in minPriorityQueue else in waiting queue.
    - in Goes in DOWN that current floor < requested floor than this request will be added in max priorityQueue else in waiting queue.

## Requirements

## Objects

- Building
- Floor
- ExternalButton
- ElevatorCar
    - Display
    - CurrentFloor
    - Directions
        - Enum UP and DOWN
    - Status
        - enums MOVING and IDEAL
    - InternalButton
- Doors

### LLD

```java
import javax.swing.event.ListDataEvent;

class Display {
    int floor;
    Direction direction;
}

enum Direction {
    UP, DOWN
}

enum STATUS {
    RUNNING, IDEAL
}

// Elevator has Display , InternalButtons . Door
//  its a dumb object it will just perform the move operation no algo and how happen is not taking care by ElevetorCar
class ElevatorCar {
    int id;
    Display display;
    int currentFloor;
    Direction direction;
    Status status;
    InternalButtons internalButtons;
    Door door;


    public void move(int destinationFloor, Direction direction) {

    }
}

// We need a Elevator controller to control the elevator 
// it is specific or one elevator , 
// Each controller manage the each elevator
class ElevatorController {
    Elevator elevator;
    MaxPriorityQueue maxPriorityQueue;  // for DOWN
    MinPriorityQueue minPriorityQueue; // for UP

    public void submitNewRequest(int floor, Doirection direction) {
        // we will get request from external and internal button, so we have external button dispatcher and Internal button dispatcher.
        // when a new 
        // we will update the datastructures
    }

    public void control() {
        // this will control 
        // move on this direction and go on that floor.
        // here all algo will work till uninterpreted
        
    }
}


class InternalButtonDispatcher {
    List<ElevatorController> elevatorControllerList;

    void submitRequest(int floor, Direction direction) {
        ElevatorController elevatorController = elevatorControllerList.filter();
        elevatorController.submitNewRequest(floor, direction);
    }
}

class ExternalButton {
    ExternalButtonDispatcher externalButtonDispatcher;

    public void pressedButton(int liftId) {
        ElevatorCar elevatorCar = elevatorControllerList.filetr(it.liftId == liftId);
        internalButtonDispatcher.submitRequest(elevatorCar);
    }
}

class ExternalButtonDispatcher {
    List<ElevatorController> elevatorControllerList;

    void submitRequest(int floor, Direction direction) {

    }
}

class OddEvenDispatcher extends ExternalButtonDispatcher {
    List<ElevatorController> elevatorControllerList;

    @Override
    void submitRequest(int floor, Direction direction) {
        super.submitRequest(floor, direction);
        ElevatorController elevatorController = elevatorControllerList.filter();
        elevatorController.submitNewRequest(floor, direction);

    }
}

class FixedFloorDispatcher extends ExternalButtonDispatcher {
    @Override
    void submitRequest(int floor, Direction direction) {
        super.submitRequest(floor, direction);
        ElevatorController elevatorController = elevatorControllerList.filter();
        elevatorController.submitNewRequest(floor, direction);
    }
}

// it has InternalButtonDispatcher
class InternalButton {
    InternalButtonDispatcher internalButtonDispatcher;
    // Each controller manage the each lift , if we have 2 lift than we have two controller to control the lift.
    List<ElevatorController> elevatorControllerList;

    public void pressedButton(int liftId) {
        ElevatorCar elevatorCar = elevatorControllerList.filetr(it.liftId == liftId);
        internalButtonDispatcher.submitRequest(elevatorCar);
    }
}


class Floor {
    int floorId;
    ExternalButton externalButton;

}


class Building {
    List<Floor> floorList;

}

class Door {

}


```