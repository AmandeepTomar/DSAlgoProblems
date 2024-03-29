package string;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Given a string s, find the length of the longest
 * substring
 *  without repeating characters.
 *
 *
 *
 * Example 1:
 *
 * Input: s = "abcabcbb"
 * Output: 3
 * Explanation: The answer is "abc", with the length of 3.
 * Example 2:
 *
 * Input: s = "bbbbb"
 * Output: 1
 * Explanation: The answer is "b", with the length of 1.
 * Example 3:
 *
 * Input: s = "pwwkew"
 * Output: 3
 * Explanation: The answer is "wke", with the length of 3.
 * Notice that the answer must be a substring, "pwke" is a subsequence and not a substring.
 * */
public class LongestSubstringWithoutRepeatingCharacters {

    public static void main(String[] args) {
        String str = "pwwkew";
        findLengthAndString(str);
    }

    private static void findLengthAndString(String str) {
        Set<Character> set = new HashSet<>();
        int left = 0;
        int maxLength = 0;
        for (int right = 0; right < str.length(); right++) {
            if(!set.contains(str.charAt(right))){
                set.add(str.charAt(right));
                maxLength = Math.max(maxLength, right-left+1);
            }else {
                while (!set.add(str.charAt(right))){
                    set.remove(str.charAt(left));
                    left++;
                }
            }
        }
        System.out.println("left "+left);
        System.out.println(maxLength);
        System.out.println(str.substring(left-1,str.length()-1));

    }
}
