package javainterviewquestions.basics.abstractclass

class ClassAKotlin(override val name: String, override var dob: String) : AbstractKotlinClass() {

    override fun getValueInDouble(): Double {
        return 3.14
    }

}