package javainterviewquestions.basics.sealedclassdetails

import java.lang.Error

sealed class Result{
    class Error(val error: java.lang.Error):Result(),Handle{
        override fun handleResponse(string: String) {
            println("handleResponse : Error$string")
        }
    }
    data class Response(val response:String):Result(),Handle{
        override fun handleResponse(string: String) {
            println("handleResponse :Response  $string")
        }
    }
    object Loading:Result(),Handle{
        override fun handleResponse(string: String) {
            println("handleResponse : Loading$string")
        }
    }
}


interface Handle{
    fun handleResponse(string: String)
}



fun main() {

    handleResponse(Result.Response("Response Successful"))
    handleResponse(Result.Error(Error("Custom Error")))
    handleResponse(Result.Loading)


}

fun handleResponse(result: Result){
    when(result){
        is Result.Loading-> result.handleResponse("Loading")
        is Result.Response-> result.handleResponse(result.response)
        is Result.Error-> result.handleResponse(result.error.toString())
    }
}
