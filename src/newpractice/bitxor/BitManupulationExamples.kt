package newpractice.bitxor

fun main() {

    oddEvenFind(5)
    oddEvenFind(4)
    swapTwoNo(4, 5)
    findTheIthBitInNo(13, 1)

    // 52 -> 32+0+8+6+4+2+0 => 52
    //     -> 1,0,0,0,1,1=> 35  => 1,0,1,0,1,1=> 16+32+3 =>51
    setTheIthBitInNo(35, 3)
    clearTheIthBit(5, 2)
    howtoFindNoOfBitsToChangeAtoB(11,17)
}

fun oddEvenFind(num: Int) {
    val andResult = (num and 1)
    if (andResult == 0) println("$num is Even")
    else
        println("$num is Odd")
}

fun swapTwoNo(num1: Int, num2: Int) {

    var a = num1 xor num2
    val b = a xor num2
    a = a xor b

    println("num1 $a and num2 $b")
}


fun findTheIthBitInNo(num: Int, ith: Int) {
    val mask = (1 shl ith)
    var res = num and mask
    if (res > 0) res = 1
    println("$ith bit of $num is $res")
}

fun setTheIthBitInNo(num: Int, ith: Int) {
    val mask = num shl ith
    var orRes = num or mask

    println("or Rs is $orRes")

    if (orRes > 0) orRes = 1
    println("set the ith$ith but to $orRes")
}

fun clearTheIthBit(num: Int, ith: Int) {
    // 5 ->  1 0 1 =
    // mast => 1 0 0 => inverse => 0 1 1 and  1 0 1 =>  0 0 1
    // clear means set 1 -> 0
    // mask -> left shift then inverse and

    val mask = num shl ith
    println(mask)
    val inverseMask = mask.inv()
    println(inverseMask)
    var res = num and inverseMask

//    if (res>0) res =1
    println("clear the ith $ith and after no is $res")
}

fun howtoFindNoOfBitsToChangeAtoB(num1: Int, num2: Int) {
    var xorvalue = num1 xor num2;
    var count = 0
    var num = xorvalue
    while (num > 0) {
        xorvalue = (xorvalue and xorvalue - 1)
      //  println(xorvalue)
        count++
        num=xorvalue
    }
    println("Value of count $count")
}
