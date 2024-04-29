package javainterviewquestions

fun main() {
    calculateTotalRevenueFromCVSData()
    val map = calculateAverageGradeOfEachStudent()
    println(map)
    println(calculateTheOldestEmployee())
    println(returnTheProductWithHighestStock())
    formatStringAndBackToOriginalWay()
}


fun returnTheProductWithHighestStock(): String {
    val csvString = "Product, Stock\nApple, 100\nBanana, 150\nOrange, 120"
//    var highestStock = Int.MIN_VALUE
//    var productName = ""
//    csvString.split("\n").drop(1).forEach { row->
//        val (product,stock) = row.split(",").map { it.trim() }
//        if(highestStock<stock.toInt()){
//            highestStock = stock.toInt()
//            productName = product
//        }
//    }
//     return "$productName -> $highestStock"


    //  val csvString = "Product, Stock\nApple, 100\nBanana, 150\nOrange, 120"

    val products = csvString.split("\n").drop(1).map { it ->

        val (product, stock) = it.split(", ")
        Pair(product, stock)
    }

    return products.maxByOrNull { it.second }?.first.orEmpty()

    // println(ans)
}

fun calculateTheOldestEmployee(): String {
    val csvString = "Name, Age, Department\nJohn, 30, IT\nAlice, 40, HR\nBob, 35, Finance"
//    var oldestAge = Int.MIN_VALUE
//    var oldestEmp = ""
//    csvString.split("\n").drop(1).forEach { row ->
//        val (name, age, _) = row.split(",").map { it.trim() }
//        if (oldestAge < age.toInt()) {
//            oldestAge = age.toInt()
//            oldestEmp = name
//        }
//    }
//
//    return "$oldestEmp -> $oldestAge"

    return csvString.split("\n").drop(1).map { row ->
        val (name, age, depart) = row.split(",").map { it.trim() }
        Pair(name, age)
    }.maxByOrNull { it.second }?.second.orEmpty()

}

fun calculateTotalRevenueFromCVSData() {
    val csvString = "Product, Quantity, Price\nApple, 10, 1.5\nOrange, 20, 1.0\nBanana, 15, 0.75"

//    val updateList = csvString.split("\n").drop(1)
//    println(updateList)
//    var totalRevenue = 0.0
//    updateList.forEach { row ->
//        val (_, quantity, price) = row.split(",").map { it.trim() }
//        totalRevenue += (quantity.toDouble() * price.toDouble())
//    }
//    println("totalRevenue = $totalRevenue")

    val totalRevenue3 = csvString.split("\n").drop(1).sumOf { row ->
        val (product, quantity, price) = row.split(",").map { it.trim() }
        quantity.toDouble() * price.toDouble()
    }

    val totalRevenue2 = csvString.split("\n").drop(1).map { row ->
        val (product, quantity, price) = row.split(",").map { it.trim() }
        quantity.toDouble() * price.toDouble()
    }.sum()

    println("totalRevenue2 $totalRevenue2")

}

fun calculateAverageGradeOfEachStudent(): Map<String, Double> {
    val csvString = "Student, Subject, Grade\nJohn, Math, 90\nAlice, Science, 85\nJohn, Science, 92\nAlice, Math, 88"
    val mapOfStudents = mutableMapOf<String, MutableList<Double>>()

    csvString.split("\n").drop(1).map { row ->
        val (student, subject, grades) = row.split(",").map { it.trim() }
        mapOfStudents.getOrPut(student) { mutableListOf<Double>() }.add(grades.toDouble())
    }

    return mapOfStudents.mapValues { (_, grades) -> grades.average() }

}

fun formatStringAndBackToOriginalWay() {
    val csv = """
        Name,Age,Address,Phone Number,Email,Favorite Number,Employed
        Burgess Greasley,33,04 Ridge Oak Street,649-893-5297,bgreasley1@4shared.com,337,true
        Derwin Brunel,13,0843 Bunting Hill,790-611-6437,dbrunel2@discovery.com,961,true
        Sheffie Spadotto,55,5298 Grover Court,265-791-1163,sspadotto3@salon.com,479,true
        Courtney Fearnyhough,63,2102 Garrison Circle,502-971-1269,cfearnyhough4@wikipedia.org,876,true
        Melloney Stickens,19,97934 Crownhardt Plaza,145-301-1842,mstickens5@facebook.com,852,false
        Ellery Geere,53,7 Kedzie Center,515-764-9730,egeere6@adobe.com,516,false
        Boone Malimoe,19,7259 Anhalt Court,776-410-0007,bmalimoe0@canalblog.com,142,false
        Nikki Goodere,61,6 Canary Parkway,827-542-0107,ngoodere7@chicagotribune.com,0,true
        Annabela Riddel,34,9132 Westridge Way,605-920-8468,ariddel8@w3.org,672,false
    """.trimIndent()

    val sortedList = csv.split("\n").drop(1).map { row ->
        val list = row.split(",")
        PersonInfo(name = list[0], age = list.getOrNull(1)?.toInt()
                ?: 0, address = list[2], phoneNo = list[3], email = list[4],
                favoriteNo = list[5].toInt(), employed = list[6].toBoolean())
    }.sortedBy { it.age }

    val formatedCsv = buildString {
        append("Name,Age,Address,Phone Number,Email,Favorite Number,Employed")
        append("\n")
        append(sortedList.joinToString("\n") { it.toString() })
    }

    println(formatedCsv)
}

data class PersonInfo(val name: String, val age: Int, val address: String, val phoneNo: String, val email: String, val favoriteNo: Int, val employed: Boolean) {
    override fun toString(): String {
        return "$name,$age,$address,$phoneNo,$email,$favoriteNo,$employed"
    }
}