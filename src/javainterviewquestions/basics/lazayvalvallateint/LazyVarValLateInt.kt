package javainterviewquestions.basics.lazayvalvallateint

private val lazy by lazy {
    println("lazy block call")
    "hello"
}

private val name:String?=null
private lateinit var newName:String

fun main() {
    println(lazy)
    println(lazy)

    // newName = name!! // throw null pointer exception
    printMethod()
    println("new name  and $name $name")

}


private fun printMethod(){
    val newNewNam = name
    println("newNewName $newNewNam")
}