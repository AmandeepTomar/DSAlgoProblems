import java.util.*

fun main() {

//    printAllNo()
//
//    println()
//
//    val data = TestData("Amit","Kumar","Android")
//    var a = "Data here"
//    a.length
//   // a.get()
//
//    println(reverseAString(" "))
//    println("gjgjg")
//
//    sovleTheStringReverseProblem("a good   example")
//
//    convertDecimaltoBinary(10)
//    println()
//    reverseANo(1234)

    pringSubSequence("abc",0,"")

}

fun pringSubSequence(s: String , index:Int,res:String) {
    var i = index
    var str = s
    var cur = res
    if(i==str.length){
        println(cur)
        return
    }
    pringSubSequence(s,i+1,cur.plus(str.get(i)))
    pringSubSequence(s,i+1,cur)

}

fun reverseANo(i: Int) {
    var res = 0
    var num = i
    while(num>0){
        res = res*10+num%10
        num = num/10
    }
    println(res)
}

fun convertDecimaltoBinary(i: Int) {
    if(i==0)
        return
    convertDecimaltoBinary(i/2)
    print(i%2)

}

fun sovleTheStringReverseProblem(s: String) {

    val str = s.trim().split(" ")
    var res = StringBuilder()
    for(i in str.size-1 downTo 1 ){
       res.append(str.get(i)).append(" ")
    }
    res.append(str[0])

    println(res)
}


fun reverseAString(str:String): String {
    val arr = str.toCharArray()
   if(arr.size==0) return ""
    for (i in 0..arr.size/2){
        var temp = arr[arr.size-(i+1)]
        arr[arr.size-(i+1)] = arr[i]
        arr[i] = temp
    }
    return String(arr)
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