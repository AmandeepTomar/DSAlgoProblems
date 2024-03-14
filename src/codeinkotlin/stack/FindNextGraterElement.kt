package codeinkotlin.stack

/***
 * Given an array arr[ ] of size N having elements, the task is to find the next greater element for each element of the array in
 * order of their appearance in the array.
 * Next greater element of an element in the array is the nearest element on the right which is greater than the current element.
 * If there does not exist next greater of current element, then next greater element for current element is -1. For example,
 * next greater of the last element is always -1.
 *
 *Input:
 * N = 5, arr[] [6 8 0 1 3]
 * Output:
 * 8 -1 1 3 -1
 * Explanation:
 * In the array, the next larger element to
 * 6 is 8, for 8 there is no larger elements
 * hence it is -1, for 0 it is 1 , for 1 it
 * is 3 and then for 3 there is no larger
 * element on right and hence -1.
 *
 * */


fun main() {
    val array = arrayOf(6 ,8 ,0 ,1 ,3)
    val res = findNextgraterElement(array)
    println(res) // 8 -1 1 3 -1
}

fun findNextgraterElement(array: Array<Int>): List<Int> {
    val res = mutableListOf<Int>()
    val stack = ArrayDeque<Int>()

    for (i in array.size-1 downTo 0){
        while (!stack.isEmpty() && stack.last()<=array[i]){
            stack.removeLast()
        }
        if (stack.isEmpty()){
            res.add(-1)
        }else{
            res.add(stack.last())
        }
        stack.addLast(array[i])
    }
    return res.reversed().toList()
}
