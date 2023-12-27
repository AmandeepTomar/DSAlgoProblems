package string

/****
 * Given two strings s and t, return true if t is an anagram of s, and false otherwise.

An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase, typically using all the original letters exactly once.



Example 1:

Input: s = "anagram", t = "nagaram"
Output: true
Example 2:

Input: s = "rat", t = "car"
Output: false


Constraints:

1 <= s.length, t.length <= 5 * 104
s and t consist of lowercase English letters.


Follow up: What if the inputs contain Unicode characters? How would you adapt your solution to such a case?
 *
 *
 * */

fun main() {
    val caseS1 = "anagram"
    val caseS2 = "nagaram"
    val case2S1 = "car"
    val case2S2 = "cat"
    println(findValidAnagram(caseS1,caseS2))
    println(findValidAnagram(case2S1,case2S2))
    println( findValidAnagramWithAlphabetFrequesncy(caseS1,caseS2))
    println( findValidAnagramWithAlphabetFrequesncy(case2S1,case2S2))

}
// here we have create the hash map and compair the both.
fun findValidAnagram(s: String, s1: String):Boolean {
   return s.length == s1.length && HashMap<Char,Int>().let {map1->
       val map2= HashMap<Char,Int>()
       s.forEach { map1[it] = map1.getOrDefault(it,0)+1}
       s1.forEach { map2[it] = map2.getOrDefault(it,0)+1}
       map1==map2
   }
}

fun findValidAnagramWithAlphabetFrequesncy(s:String,s1:String): Boolean {
    if (s.length != s1.length) return false
    val map = IntArray(26){0}

    for (c in s.toCharArray()){
        map[c-'a']++
    }
    for (c in s1.toCharArray()) {
        if (map[c-'a'] == 0) return false
        map[c - 'a']--
    }
    return true
}
