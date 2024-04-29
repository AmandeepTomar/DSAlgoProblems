package binarysearch

import newpractice.bitxor.findTheIthBitInNo


/***
 * */
fun main() {
    // find minimum in sorted array
    val array = arrayOf(3, 4, 5, 1, 2)
    val index = findMinimumInSortedRotatedArray(array)
    println(index)

    // find maximum in sorted array and peek element.
    val maximum = findMaximumInSortedRoatedArray(array)
    println(array[maximum])

    // find a first and last occurrence of a digit in sorted array
    val array1 = arrayOf(2, 2, 3, 4, 4, 4, 4, 6, 8, 9)
    val isFirstOccurrence = true // just make it false and you will get the last occurrence of item.
    val target = 4
    val firstOccurrence = findFirstOccrrenceInSortedArray(array1, isFirstOccurrence, target)
    println("First Occurrence of $target is at $firstOccurrence Index , value at index is ${array1[firstOccurrence]}")

    // find the smallest character grater than target.
    val array2 = arrayOf('c','f','j')
    val targetChar = 'a'
    val latter = findTheSmallestLatterGraterThanTarger(array2,targetChar)
    println("the smallest character grater than target is $latter -- ${array2[latter]}")


}

fun findTheSmallestLatterGraterThanTarger(array: Array<Char>, targetChar: Char): Int {
    var start = 0;
    var end = array.size - 1
    var ans = -1
    while (start<=end){
        val mid = start + (end - start)/2
        if(array[mid]<=targetChar){
            start = mid+1
        }else{
            end = mid-1
            ans = mid
        }
    }
    return ans
}

fun findFirstOccrrenceInSortedArray(array: Array<Int>, firstOccurrence: Boolean, target: Int): Int {
    var start = 0;
    var end = array.size - 1
    var ans = -1
    while (start <= end) {
        val mid = start + (end - start) / 2
        if (array[mid] == target) {
            ans = mid
            if (firstOccurrence) {
                end = mid - 1
            } else {
                start = mid + 1
            }
        } else if (array[mid] > target) {
            end = mid - 1
        } else {
            start = mid + 1
        }
    }
    return ans
}

fun findMaximumInSortedRoatedArray(array: Array<Int>): Int {
    var start = 0
    var end = array.size - 1
    while (start < end) {
        val mid = start + (end - start) / 2
        if (mid > 0 && (array[mid] > array[mid - 1] && array[mid] > array[mid + 1])) {
            return mid
        } else if (array[mid] < array[end]) {
            end = mid - 1
        } else {
            start = mid + 1
        }
    }
    return -1
}


fun findMinimumInSortedRotatedArray(array: Array<Int>): Int {
    var start = 0;
    var end = array.size - 1
    var res = array[0]
    if (array[end] > array[start]) {
        return res
    }
    while (start <= end) {
        val mid = start + (end - start) / 2
        res = res.coerceAtMost(array[mid])
        if (array[mid] < array[end]) {
            end = mid - 1
        } else {
            start = mid + 1
        }
    }
    return res
}
