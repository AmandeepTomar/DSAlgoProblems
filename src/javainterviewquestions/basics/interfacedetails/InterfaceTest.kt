package javainterviewquestions.basics.interfacedetails

fun main() {

    val test = Test("constantValue","constantValuesWithVal")
    test.defaultImplementation()
    test.run()
    println(test.constantalue)
    println(test.constantValValue)

    println(KotlinInterface.values)
    println(KotlinInterface.valuesWithVal)
    KotlinInterface.staticImplementation()
}

class Test(override var constantalue: String, override val constantValValue: String) : KotlinInterface{
    override fun run() {
        println("Run method")
    }

}