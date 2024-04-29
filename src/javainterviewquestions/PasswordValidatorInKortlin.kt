package javainterviewquestions


// Password must be 8 in length , password must have 1 special , 1 digit and 1 Upper case and 1 lowercase.
fun main() {
    val input = "Amandeep@123"
    val input2 = "Ama@123"
    println("true ${validPassword(input)}")
    println("false ${validPassword(input2)}")
}

fun validPassword(input: String): Boolean {
    if (input.length<8) return false
    if (!input.any { it.isDigit() }) return false
    if (!input.any { it.isUpperCase() }) return false
    if (!input.any { it.isLowerCase() }) return false
    if (input.all { it.isLetterOrDigit() }) return false
    return true
}
