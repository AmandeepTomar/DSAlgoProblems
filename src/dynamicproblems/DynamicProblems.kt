package dynamicproblems

fun main() {

    val dp: Array<IntArray> = Array(3) { IntArray(3) }

    for (i in dp.size-1 downTo 0){
        for (j in dp.size-1 downTo 0){
            print(dp[i][j])
        }
        println()
    }


    sum(::addTwo)

}

fun addTwo(a:Int,b:Int):Int{
    return a+b
}
fun sum(onResult:(Int,Int)->Int){
    ::addTwo
}

