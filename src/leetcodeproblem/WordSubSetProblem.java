package leetcodeproblem;

import java.util.ArrayList;
import java.util.List;

/**
 * 916. Word Subsets
 * Solved
 * Medium
 * Topics
 * Companies
 * You are given two string arrays words1 and words2.
 *
 * A string b is a subset of string a if every letter in b occurs in a including multiplicity.
 *
 * For example, "wrr" is a subset of "warrior" but is not a subset of "world".
 * A string a from words1 is universal if for every string b in words2, b is a subset of a.
 *
 * Return an array of all the universal strings in words1. You may return the answer in any order.
 *
 *
 *
 * Example 1:
 *
 * Input: words1 = ["amazon","apple","facebook","google","leetcode"], words2 = ["e","o"]
 * Output: ["facebook","google","leetcode"]
 * Example 2:
 *
 * Input: words1 = ["amazon","apple","facebook","google","leetcode"], words2 = ["l","e"]
 * Output: ["apple","google","leetcode"]
 * */
public class WordSubSetProblem {

    public static void main(String[] args) {
        String s1[]={"amazon","apple","facebook","google","leetcode"};
        String s2[]={"e","o"};
       List<String> curr =  wordSetProblem(s1,s2);
        System.out.println("List of Word Set "+curr);
    }
// 1. maxfreq
    //2. freq of each word of s2
    // 3. now chck with each words of s1
    private static List<String> wordSetProblem(String[] s1, String[] s2) {
        List<String> res = new ArrayList<>();
        int maxfreq[] = new int[26];
        for(String curr:s2){
            int [] currFreq = new int[26];
            for (char ch : curr.toCharArray()){
                currFreq[ch-'a']++;
            }
            for (int i = 0; i <26; i++) {
                maxfreq[i]=Math.max(maxfreq[i],currFreq[i]);
            }
        }

        for (String curr : s1){
            int currFreq[]= new int[26];
            for (char ch : curr.toCharArray()){
                currFreq[ch-'a']++;
            }
            for (int i = 0; i <26 ; i++) {
                if(maxfreq[i]>currFreq[i]) {
                    break;
                }
                if (i==25)res.add(curr);
            }
        }

        return res;
    }
}
