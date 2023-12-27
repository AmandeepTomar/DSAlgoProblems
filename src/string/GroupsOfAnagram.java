package string;

import javax.swing.*;
import java.util.*;

/**
 * Given an array of strings strs, group the anagrams together. You can return the answer in any order.
 *
 * An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase, typically using all the original letters exactly once.
 *
 *
 *
 * Example 1:
 *
 * Input: strs = ["eat","tea","tan","ate","nat","bat"]
 * Output: [["bat"],["nat","tan"],["ate","eat","tea"]]
 * Example 2:
 *
 * Input: strs = [""]
 * Output: [[""]]
 * Example 3:
 *
 * Input: strs = ["a"]
 * Output: [["a"]]
 * */
public class GroupsOfAnagram {

    public static void main(String[] args) {
        String str[]=new String[]{"eat","tea","tan","ate","nat","bat"};
        System.out.println(groupAnagrams(str));

    }

    public static  List<List<String>> groupAnagrams(String[] strs) {
        // we have create a hash map of String and List of Strings
        // we pick each words and then short the words and save in sah map as key.
        // save actual word in list.
        // we check if sorted workds is not in hashmap then add that word with empty Array List.

        Map<String,List<String>> map= new HashMap<>();
        for (String words : strs){
            char[] chars = words.toCharArray();
            Arrays.sort(chars);
            String sortedWord = new String(chars);

            if (!map.containsKey(sortedWord)){
                map.put(sortedWord,new ArrayList<>());
            }
            map.get(sortedWord).add(words);
        }

        return new ArrayList<>(map.values());
    }


}
