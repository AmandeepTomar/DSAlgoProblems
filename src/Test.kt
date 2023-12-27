fun main() {

    // As this one is int operation ,  it is like an
    // 10/2 = 5 and 11/2 = 5.5 that is 5 in int

    val a =10
    val b=11
    if (a/2==5){
        println(" a is 10")
    }

    if (b/2==5){
        println(" a is 11")
    }

    val s = "newData"
    val t = "newDatt"

    val values =  s.groupingBy { it }.eachCount() == t.groupingBy { it }.eachCount()
    println(values)

}