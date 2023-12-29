## This files contains the information of 
- Abstract 
- Interface 
- Sealed classes 

### Abstract classes 
- Abstract class is a class that can have both abstract and non-abstract methods,
- Cannot be instantiated on its own
- It serves as a base class for the class to inherit form. A non abstract class must implement all the abstract methods of the class.
- Abstract classes can have constructors, member variables, and methods with varying access levels (public, private, protected).
- Can not declare veriable as abstractin Java.
- In kotlin property can be abstract and need to override in child class constructor.
Example:
```kotlin
abstract class AbstractKotlinClass {
abstract val name:String
abstract var dob:String
abstract fun getValueInDouble():Double    
}

class ClassAKotlin(override val name: String, override var dob: String) : AbstractKotlinClass() {
override fun getValueInDouble(): Double {
return 3.14
}
}
```
When we extends the AbstractKotlinClass class in Java. then all property members will be override as methods in java.
```java
public class ClassExtendsAbstractKotlin extends AbstractKotlinClass{

    @NotNull
    @Override
    public String getName() {
        return null;
    }

    @NotNull
    @Override
    public String getDob() {
        return null;
    }

    @Override
    public void setDob(@NotNull String s) {

    }

    @Override
    public double getValueInDouble() {
        return 0;
    }
}
```


NOTE:- if child class is Java and parent class is  AbstractKotlinClass then all properties will be override as methods in JAVA.


#### Q. Can you describe any pitfalls or challenges you've encountered when working with abstract classes in large-scale Kotlin projects?
Ans Challenges and Pitfalls with Abstract Classes in Large-Scale Kotlin Projects:

**Tight Coupling:**
One of the primary challenges can be the tight coupling between abstract classes and their implementations. When multiple classes extend the same abstract class, any changes to the abstract class can potentially affect all its derived classes. This tight coupling can make the system less flexible and harder to maintain.

**Overhead of Abstraction:**

Overuse of abstract classes can lead to an overly abstracted design, making the codebase harder to understand for new developers. While abstract classes are excellent for defining a blueprint, excessive abstraction can obfuscate the actual functionality of the derived classes.

**Multiple Inheritance Limitations:**

Unlike some other programming languages, Kotlin doesn't support multiple class inheritance. This means that if a class extends an abstract class, it cannot extend any other class, which can be limiting in certain design scenarios where multiple inheritance would have been beneficial.

**Initialization Challenges:**

Abstract classes can have constructors, but they cannot be instantiated directly. This can lead to challenges when trying to initialize complex objects or when dealing with dependency injection frameworks that may require concrete classes for instantiation.

**Testing Difficulties:**

Testing classes that inherit from abstract classes can be challenging. Since abstract classes cannot be instantiated, you often need to create concrete subclasses or use mocking frameworks to test functionality, which can increase the complexity of unit tests.

**Versioning and Evolution:**

As the project grows, evolving abstract classes without breaking existing implementations becomes a challenge. Any modifications to the abstract class can introduce breaking changes, necessitating careful planning and versioning strategies to maintain backward compatibility.

**Understanding Contract:**

Abstract classes define a contract that derived classes must follow. Ensuring that all derived classes adhere to this contract can be challenging, especially in large-scale projects where developers might not have a holistic view of all classes extending the abstract class.

**Performance Concerns:**

While abstract classes themselves don't introduce significant performance overhead, improper usage or complex hierarchies can lead to performance issues, especially if there's deep nesting or excessive method calls between abstract and concrete implementations.

**Mitigation Strategies:**

**Clear Documentation:** Ensure that abstract classes are well-documented, highlighting their purpose, expected behaviors, and guidelines for extension.

**Code Reviews:** Regular code reviews can help identify potential coupling issues, over-abstraction, or other challenges early in the development cycle.

**Refactoring:** Periodically review the abstract class hierarchy to identify opportunities for refactoring, simplifying, or breaking down into smaller, more manageable components.

**Use Interfaces Where Appropriate:** Instead of always resorting to abstract classes, evaluate whether interfaces can fulfill the requirements. Interfaces can offer flexibility and avoid some of the challenges associated with abstract classes.

#### Q. How would you refactor code that heavily relies on abstract classes to make it more maintainable or extensible 
Ans
**Evaluate Abstraction Depth:**

If there are multiple levels of abstraction or if the abstract classes have numerous responsibilities, consider breaking them down into smaller, more focused abstractions.

**Introduce Composition Over Inheritance:**

Wherever possible, favor composition over inheritance. Instead of relying solely on abstract classes to share behavior, encapsulate common functionalities in separate classes or components and compose them within the concrete classes.

**Use Interfaces for Contracts:**

Interfaces promote loose coupling, allowing classes to implement multiple contracts without the constraints of class inheritance.

**Apply the Strategy Pattern:**

Consider refactoring these areas using the Strategy Pattern. Define a family of algorithms, encapsulate each one in a separate class, and make them interchangeable within the context classes.

**Refactor to a Mixin Pattern:**

For shared functionalities that are not inherently tied to a specific class hierarchy, consider using the Mixin Pattern. Create mixin classes that encapsulate reusable behaviors and mix them into classes where the functionalities are required, promoting code reuse without deep inheritance hierarchies.


**Simplify and Flatten Hierarchies:**

Avoid creating overly complex hierarchies with deep nesting or intricate relationships between abstract classes. Aim for a more straightforward, streamlined design that promotes clarity and maintainability.

**Adopt Dependency Injection:**

Utilize dependency injection frameworks or principles to decouple components and dependencies within the system. Instead of tightly coupling classes to specific abstract implementations, inject dependencies at runtime, promoting flexibility, and testability.

**Refactor Gradually with Testing:**



#### Q. Are you familiar with any design patterns where abstract classes play a crucial role? Can you provide an example?
**Template Method Pattern:**

Definition:
The Template Method Pattern defines the structure of an algorithm in an abstract class but delegates some steps to the derived classes. It allows subclasses to redefine certain steps of an algorithm without changing its structure.

#### Q. How can you use abstract classes effectively to achieve a cleaner design in Kotlin? 

**Define a Clear Contract:**
**Encapsulate Common Functionality:**
**Promote Flexibility and Extensibility:**
**Facilitate Testability and Modularity:**
**Balance Abstraction and Complexity:**


#### Q.What are sealed classes in Kotlin, and how can they be combined with interfaces?

```kotlin
sealed class Result {
    data class Success(val data: String) : Result()
    data class Error(val message: String) : Result()
    object Loading : Result()
}

```

```kotlin
// Sealed Class Definition
sealed class Result {
    data class Success(val data: String) : Result(), ResultBehavior {
        override fun handleSuccess() {
            println("Handling success with data: $data")
        }
    }

    data class Error(val message: String) : Result(), ResultBehavior {
        override fun handleError() {
            println("Handling error with message: $message")
        }
    }

    object Loading : Result(), ResultBehavior {
        override fun handleLoading() {
            println("Handling loading state")
        }
    }
}

// Interface Definition
interface ResultBehavior {
    fun handleSuccess() {
        // Default or specific implementation for handling success
    }

    fun handleError() {
        // Default or specific implementation for handling error
    }

    fun handleLoading() {
        // Default or specific implementation for handling loading
    }
}

// Usage
fun handleResult(result: Result) {
    when (result) {
        is Result.Success -> result.handleSuccess()
        is Result.Error -> result.handleError()
        is Result.Loading -> result.handleLoading()
    }
}

```

### Q. Can you give an example of a design pattern where interfaces play a crucial role, like Strategy or Observer pattern?
Strategy Pattern Overview:
The Strategy pattern is a behavioral design pattern that enables selecting an algorithm's implementation at runtime. It defines a family of algorithms, encapsulates each algorithm, and makes them interchangeable.

Components of Strategy Pattern:
**Strategy Interface:** 
Defines a contract for algorithm implementations.

**Concrete Strategies:** 
Implements the Strategy interface with specific algorithms.

**Context:** 
Maintains a reference to a Strategy object and allows clients to switch strategies dynamically.

```kotlin
// Strategy Interface
interface SortStrategy<T : Comparable<T>> {
    fun sort(list: MutableList<T>): MutableList<T>
}

// Concrete Strategy - Bubble Sort
class BubbleSort<T : Comparable<T>> : SortStrategy<T> {
    override fun sort(list: MutableList<T>): MutableList<T> {
        for (i in 0 until list.size) {
            for (j in 0 until list.size - i - 1) {
                if (list[j] > list[j + 1]) {
                    val temp = list[j]
                    list[j] = list[j + 1]
                    list[j + 1] = temp
                }
            }
        }
        return list
    }
}

// Concrete Strategy - Quick Sort
class QuickSort<T : Comparable<T>> : SortStrategy<T> {
    override fun sort(list: MutableList<T>): MutableList<T> {
        if (list.size <= 1) return list
        val pivot = list[list.size / 2]
        val equal = list.filter { it == pivot }.toMutableList()
        val less = list.filter { it < pivot }.toMutableList()
        val greater = list.filter { it > pivot }.toMutableList()
        return sort(less) + equal + sort(greater)
    }
}

// Context
class Sorter<T : Comparable<T>>(private var strategy: SortStrategy<T>) {
    fun setStrategy(strategy: SortStrategy<T>) {
        this.strategy = strategy
    }

    fun sortList(list: MutableList<T>): MutableList<T> {
        return strategy.sort(list.toMutableList())
    }
}

fun main() {
    val numbers = mutableListOf(5, 2, 9, 1, 5, 6)
    val sorter = Sorter(BubbleSort())

    println("Sorted using Bubble Sort: ${sorter.sortList(numbers)}")

    sorter.setStrategy(QuickSort())
    println("Sorted using Quick Sort: ${sorter.sortList(numbers)}")
}


```

###### ====================================================

### Interface 
- Interfaces is by default adbtract and public before java8 , after that we also have default and static method in interface, they also have body of methods.
- It provide a contract that class can implement. Any class that implement the interface must provide the concrete implementation of all the abstract method in interface.
- Interface provide the multiple inheritance. A class can implement the multiple interfaces. 
- Property initialization is not allowed in kotlin
- In interface with companion object we can declare the val, var variable with values and also static methods.
- We can define the const val variable in companion object in `interface`, but cat not be acces in implemented object. its throwing runtime exception.
- delegation is a design pattern where an object delegates some of its responsibilities to another object.
- for example , just like we have BaseActivity for logging Analytics and Deeplink so two base activity now. so we cen remove them with delegates. its composition over inheritance.
- **Benefits of Interface Delegation:**
  - **Code Reusability:** Delegation promotes code reuse by allowing classes to reuse method implementations from other classes or objects.
  
  - **Composition over Inheritance:** By using delegation, you can achieve code reuse and flexibility without inheriting from specific classes. This promotes composition, making the codebase more modular, maintainable, and extensible.

  - **Runtime Flexibility:** Delegation allows you to change behavior dynamically at runtime by providing different delegate objects to the delegating class.
- **Payment Processing System: Real world example.**
  Interface: Define a PaymentMethod interface with methods like authorize(), capture(), refund().
  Concrete Implementations: Implement the PaymentMethod interface in classes like CreditCardPayment, PayPalPayment, BankTransfer, etc.
- 