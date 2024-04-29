package javainterviewquestions

class TestExtension {


}

public fun TestExtension.itIsModifier(): String {
    return "Called TestExtension"
}


sealed class Test {

}

sealed class Testdata : Test() {

}