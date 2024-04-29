package javainterviewquestions

fun main() {

    val userList = listOf(
            User("Amandeep","Amandeep Tomaer",31),
            User("Komal","Amandeep Chauhan",27),
            User("Himanshu","Amandeep Chauhan",25),
            User("Kajol","Amandeep Chauhan",24),
            User("Ekansh","Amandeep Shrivastav",36),
            User("Annu","Amandeep Shrivastav",32),
            User("Gaurav","Gaurav Chauhan",33),
    )

    println(userList)
    val sortedlist = userList.sortedByDescending { it.age }
    println(sortedlist)

   val sample =  TestExtension()

    val CallExtensioFuxtion = sample.itIsModifier()

}
data class User(val name: String,val fullName:String,val age:Int)
