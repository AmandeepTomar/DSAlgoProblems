import java.util.*

fun main() {

    printAllNo()

    println()

    val data = TestData("Amit","Kumar","Android")

}


class TestData(firstName:String, secondName:String){

    init {
        println("First name $firstName")
    }

    private val fullNamn = firstName+secondName.also { println("Inside also") }

    constructor(firstName: String,secondName: String,category:String):this(firstName, secondName){
        println("second name $secondName")
    }

    init {
        println("fullname length ${fullNamn.length}")
    }
}



fun printAllNo(){
    val arr =  IntArray(100);
    var count = 1;

    Arrays.fill(arr,0);

    // 3, 4, 5, 4
    while(count!=99){
        val no = getRandomInt()
        if(arr[no-1] ==0 && no != arr[no-1]){
            arr[no-1] = no
            count++;
        }
    }

    println(arr.contentToString())


}


fun getRandomInt(): Int {

    return (1 + kotlin.random.Random.nextInt(0, 100))

}