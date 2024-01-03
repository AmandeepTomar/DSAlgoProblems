## SOLID PRINCIPLE 
In this repository we have discussed the SOLID principle.
* S-> Single Responsibility
* O -> Open for extension close for modification.
* L-> Liskov
* I->Interface
* D-> Dependency Inversion

### Advantages of Applying SOLID Principles in Kotlin:

- **Maintainability:** By following SOLID principles, your code becomes easier to maintain. Each class or module has a clear responsibility, making it easier to find and fix issues or add new features.

- **Flexibility:** SOLID principles promote designs that are flexible and can evolve over time without requiring extensive modifications.

- **Testability:** With SOLID principles, your code becomes more modular and decoupled, making it easier to write unit tests. You can mock dependencies and write tests with greater confidence.

- **Scalability:** As your application grows, adhering to SOLID principles helps in managing complexity. You can extend functionality by adding new classes or modules without modifying existing code, reducing the risk of introducing bugs.

- **Reusability:** By creating classes and modules that are cohesive and loosely coupled, you increase the chances of reusing components in different parts of your application or in other projects

### S->SINGLE RESPONSIBILITY 
A class should have one reason to change. Class should have single responsibility.

## Example
1. Another Example of Marker , Invoice class , InvoicePrinter and InvoiceSaveTODB class .
   - As first Invoice class have all three responsibility
     1. Calculate Price
     2. Print Invoice
     3. Save Invoice in DB After device the responsibility in three class. so each class has exact one reason to change.
2. Example of Square class 
   1. First Square class have all the logic of calculation and rending.
   2. In second Approach we have decided to create two classes 
      1. Square class with calculation logic 
      2. SquareRenderUi class with render Ui logic.

    
## O -> Open for extension close for modification.
- In Simple words do not modify the class already tested class just extend it with new requirements.
- Take the example of Marker and Printer class. 
- As we have created a class to save the invoice in db and code is live. now we have new requirements.
- New Requirement is 
  - Save the invoice in file also. 
  - Now we have created an `intercae SaveInvoice` that will be implemented by two class `SaveInvoiceToDB` and `SaveInvoiceToFile`
  - this we will every time extends the functionality as we required new functionality.

Code with Open for extension close for modification.

```kotlin
interface SaveInvoice {
    fun saveInvoice()
}

class SaveInvoiceInDB : SaveInvoice {
    override fun saveInvoice() {
        // save Invoice in DB
    }
}

class SaveInvoiceInFile : SaveInvoice {
    override fun saveInvoice() {
        // save invoice in file
    }
}
```

// previous code that break the principle 

```kotlin
class InvoiceSaveDB{
    val invoice:Invoice
    constructor(invoice:Invoice){
        this.invoice = Invoice
    }
    
    fun saveInDB(){
        // save in DB 
    }
    
    fun saveInFile(){
        // save in file 
    }
    
    // as we add the new method it will break the principle
// so solution is listed above.
}
```

## L -> Liskove 
- Subclass should extend the capabilities of parent class without narrow it down.
- Object of Subclass are interconvertible without breaking its functionality.
- If `classB` subtype of `classA`, then we should be able to replace the object of A with B without breaking the behaviour of program.

#### Example 
- Suppose we have a Object Car and RacingCar and SportCar each car have different size of tayers.
- // Code of bad code. 
```kotlin
open class Car {
    fun getCarTyreWidth() = 18
}

class RacingCar : Car{
    fun getRacingCarTyreWidth() = 28
}

class SportsCar : Car{
    fun getSportsCarTypeWidth() = 21
}

fun main() {
    val list = mutableListOf(RacingCar(), Car())
    list.forEach { car ->
        when (car) {
            is RacingCar -> car.getRacingCarTyreWidth()
            is SportsCar ->car.getSportsCarTypeWidth()
            is Car -> car.getCarTyreWidth()
        }
    }

    // this implementation have issue like Racing car is not interchangeable with car object.
    // to fix this we will create an interface that will be implemented by both class so both can interchangeable.
    // As show in for loop we need to put the check for each type of class. like Car ,RacingcAr , SportCar so on.
}

// with the principle. 
interface Vehicle {

    fun getVehicleTypeWidth(): Int
}

class NewCar : Vehicle {
    override fun getVehicleTypeWidth(): Int {
        return this.getCarTypeWidth()
    }

    private fun getCarTypeWidth() = 32

}

class NewRacingCar : Vehicle {

    override fun getVehicleTypeWidth(): Int {
        return this.getTyreWidth()
    }

    private fun getTyreWidth() = 32
}

class NewSportCar : Vehicle {

    override fun getVehicleTypeWidth(): Int {
        return this.getSportsCarTyreWidth()
    }

    private fun getSportsCarTyreWidth() = 28
}

main(){
    val newList = mutableListOf(NewCar(), NewRacingCar(), NewSportCar())
    newList.forEach {
        println(it.getVehicleTypeWidth())
    }
}

```


## I -> Segregation of Interfaces
Device the interfaces in small action.
Example 
1. Wew have a IPrinter `interface`

```kotlin

interface IPrinter{
    fun print()
    fun printDetails()
    fun fax()
    fun faxSave()
    fun scan()
    fun scanCompleted()
}
```
- this interface has a lot of function , suppose some use cases 
- Some printer have only print feature then fax and scan will be un-necessary  so we will segregate the `Iprinter` interface into three interfaces
  - IPrinter -> `print()` and `printDetails()`
  - IFax -> `fax()` and `faxServer()`
  - IScan -> `scan()` and `scanCopleted()`

## D -> Dependency Inversion 
- High level module should not depends on Low level modules , both depends on abstraction.
- Class should depends on `interface` rather than concrete class.
## Example
- Suppose we have a class `MacBook` that required `KeyBoad` and `Mouse`
- Bad implementation

```kotlin


interface KeyBoard {
}

interface Mouse {}

class WiredKeyboard : KeyBoard {

}

class WireLessKeyBoard : KeyBoard{}

class WiredMouse : Mouse{}
class WireLessMouse: Mouse{}


class MackBook(val keyBoard:WiredKeyboard , val mouse:WiredMouse) {}

// implementation with DI 
// this class is not depends on concrete class its depends on interface
class MackBook(val keyBoard:KeyBoard , val mouse:Mouse) {}


```

