package codeinkotlin.hashmapcreation.stack


/***
 * Given an array a of integers of length n, find the nearest smaller number for every element such that the smaller element
 * is on left side.If no small element present on the left print -1.
 *Input: n = 6
 * a = {1, 5, 0, 3, 4, 5}
 * Output: -1 1 -1 0 3 4
 * Explaination: Upto 3 it is easy to see
 * the smaller numbers. But for 4 the smaller
 * numbers are 1, 0 and 3. But among them 3
 * is closest. Similary for 5 it is 4.
 *
 * */
fun main() {

    val array = arrayOf(1, 5, 0, 3, 4, 5)
    val ans = arrayOf(-1 ,1 ,-1, 0, 3, 4)
    val list = findPreviousSmallestElement(array)
    println(list)

}

fun findPreviousSmallestElement(array: Array<Int>):List<Int> {
    val result = mutableListOf<Int>()
    val stack = ArrayDeque<Int>()

    for (i in array){
        while(!stack.isEmpty() && stack.last()>=i){
            stack.removeLast()
        }
        if(stack.isEmpty()){
            result.add(-1)
        }else{
            result.add(stack.last())
        }
        stack.addLast(i)
    }
    return result.toList()
}
