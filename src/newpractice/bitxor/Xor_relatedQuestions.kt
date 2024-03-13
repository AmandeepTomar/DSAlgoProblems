package newpractice.bitxor

fun main() {

    val array = intArrayOf(5, 4, 1, 4, 3, 5, 1)
    findNonRepeatingElementWhileEveryElementRepeatedtwice(array)
    findNonRepeatingElementWhileEveryElementRepeatedtwiceUsingSet(array)
    val arrayWithTwoUnique = intArrayOf(5,4,1,4,3,5,1,11)
    findTwoNonRepeatingElementWhereAllElementsRepeatedTwice(arrayWithTwoUnique)
    val arr = intArrayOf(4, 2, 4, 5, 2, 3, 3, 1, 1)
    val k = 5
    findNonRepeatingElementWhereEachElementOccureKTimes(arr,k)

    findPalindromeOfNum(121)

    println((5 shr 1))
    println((5 shl 1))
}

fun findPalindromeOfNum(int: Int){
    var res = 0;
    var num = int
    while (num>0){
        var rem = num%10
        res  = res*10 + num%10
        num = num/10
    }

    println("Reverse Num is $res")
}

fun findTwoNonRepeatingElementWhereAllElementsRepeatedTwice(arrayWithTwoUnique: IntArray) {
    var res = 0
    for((index , value ) in arrayWithTwoUnique.withIndex()){
        res = res xor value
    }


    // this one is the way to calculate the rightMostSetBit of Number
    var x =0
    var y =0
    val rightMostSetBit = res and -res
    println(rightMostSetBit)
    for (i in arrayWithTwoUnique){
        if (i and rightMostSetBit==0)
            x = x xor  i
        else
            y = y xor i
    }
    println(" x $x and y  $y")

}

fun findNonRepeatingElementWhileEveryElementRepeatedtwice(array: IntArray) {
    var res = 0
    for (i in array) {
        res = res xor i
    }
    println("Non repeating element is $res")
}
fun findNonRepeatingElementWhileEveryElementRepeatedtwiceUsingSet(array: IntArray) {
    var res = HashSet<Int>()
    for (i in array) {
        if (res.contains(i)){
            res.remove(i)
        }else
            res.add(i)
    }
    println("Non repeating element is ${res.first()}")
}

// not working
fun findNonRepeatingElementWhereEachElementOccureKTimes(array: IntArray, k:Int) {
    val INT_SIZE = 32 // Assuming integers are 32 bits

    // Create an array to store the count of set bits at each position
    val countBits = IntArray(INT_SIZE)

    // Calculate the count of set bits at each position
    for (element in array) {
        for (i in 0 until INT_SIZE) {
            if ((element and (1 shl i)) != 0) {
                countBits[i] = (countBits[i] + 1) % k
            }
        }
    }

    // Reconstruct the unique element using the count of set bits
    var result = 0
    for (i in 0 until INT_SIZE) {
        if (countBits[i] != 0) {
            result = result or (1 shl i)
        }
    }

    println("Result is $result")
}
