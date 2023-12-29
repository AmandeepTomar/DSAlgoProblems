package javainterviewquestions.basics.interfacedetails

interface KotlinInterface {
    // define property

    var constantalue :String
    val constantValValue :String


    fun run()

    fun defaultImplementation(){
        println("default implementation")
    }

    companion object{
        var values:String ="values"
        val valuesWithVal:String ="valuesWithVal"
        fun staticImplementation(){
            println("static implementation")
        }
    }
}