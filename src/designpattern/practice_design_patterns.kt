package designpattern


fun main() {

    val loggerFactory = LoggerFactory()
    loggerFactory.createLogger(LoggerType.ANALYTICS).logeMessage()
    loggerFactory.createLogger(LoggerType.DB).logeMessage()
    loggerFactory.createLogger(LoggerType.API).logeMessage()


    val vegDelight = VegDelightPizza()
    println(vegDelight.cost())
    val addMushroom = Mushroom(vegDelight)
    println(addMushroom.cost())
    val addPaneer = Paneer(addMushroom)
    println(addPaneer.cost())

    val onlyName = Student1().setName("Name").build()
    val withAllInfor = Student1().setName("Firstname").setLastName("LastName").setFatherName("fathserName").setGrade("A").build()

    println(onlyName.toString())
    println(withAllInfor.toString())

}
// ==================== builder Design Pattern

class Student1 : StudentBuilder() {
}

abstract class StudentBuilder {

    var firstName: String = ""
        private set
    var lastName: String = ""
        private set

    var fatherName: String = ""
        private set

    var grade: String = ""
        private set

    fun setName(firstName: String): StudentBuilder {
        this.firstName = firstName
        return this
    }

    fun setLastName(firstName: String): StudentBuilder {
        this.lastName = firstName
        return this
    }

    fun setFatherName(fatherName: String): StudentBuilder {
        this.fatherName = fatherName
        return this
    }

    fun setGrade(grade: String): StudentBuilder {
        this.grade = grade
        return this
    }


    fun build(): Student {
        return Student(this)
    }
}

class Student {

    var firstName: String? = null
    var lastName: String? = null
    var fatherName: String? = null
    var grader: String? = null

    constructor(studentBuilder: StudentBuilder) {
        this.firstName = studentBuilder.firstName
        this.lastName = studentBuilder.lastName
        this.fatherName = studentBuilder.fatherName
        this.grader = studentBuilder.grade
    }

    override fun toString(): String {
        return "firstName = $firstName , lastname = $lastName, fathername = $fatherName, grade=$grader"
    }
}


// ======================== Decorator Design Patter

interface BasePizza {
    fun cost(): Int
}

class VegDelightPizza : BasePizza {
    override fun cost(): Int {
        return 100
    }
}

class CheesePizza : BasePizza {
    override fun cost(): Int {
        return 200
    }
}

class ForestPizza : BasePizza {
    override fun cost(): Int {
        return 300
    }
}

// we want to add cheseust , paneer , mushroom

abstract class Toppings : BasePizza

class Mushroom(private val basePizza: BasePizza) : Toppings() {
    override fun cost(): Int {
        return basePizza.cost() + 100
    }
}

class Paneer(private val basePizza: BasePizza) : Toppings() {
    override fun cost(): Int {
        return basePizza.cost() + 100
    }
}

class CheeseBurst(private val basePizza: BasePizza) : Toppings() {
    override fun cost(): Int {
        return basePizza.cost() + 100
    }
}


// =============================== Factory Design Pattern
interface Logger {
    fun logeMessage()
}

enum class LoggerType {
    ANALYTICS, DB, API
}

class ApitLog : Logger {
    override fun logeMessage() {
        println("Api logger")
    }
}

class DbLog : Logger {
    override fun logeMessage() {
        println("Db logger")
    }
}

class AnalyticsLogger : Logger {
    override fun logeMessage() {
        println("AnalyticsLogger logger")
    }
}

class LoggerFactory {
    fun createLogger(loggerType: LoggerType): Logger {
        return when (loggerType) {
            LoggerType.API -> ApitLog()
            LoggerType.DB -> DbLog()
            LoggerType.ANALYTICS -> AnalyticsLogger()
        }
    }
}