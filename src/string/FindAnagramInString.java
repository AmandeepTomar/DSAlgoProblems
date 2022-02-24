package string;

import java.util.HashMap;
import java.util.Objects;

/**
 * ANAGRAM means the frequency of character is same.
 * like abac where a=2, b=1,c=1 so abac == baca coz both have same frequency of each character.
 *
 * Scheducode
 * 1. Create two map to store frequency of source and pattern
 * 2 Now check source and pattern till last
 *  Use Sliding window technique
 *      - Acquire one and release one.
 * */
public class FindAnagramInString {
    public static void main(String[] args) {
        String source="abcabaccba";
        String pattern="abac";
        findAnagramInString(source,pattern);
    }

    private static void findAnagramInString(String source, String pattern) {
        HashMap<Character,Integer> sMap=new HashMap<>();
        HashMap<Character,Integer> pMap=new HashMap<>();

        for (int i = 0; i <pattern.length() ; i++) {
            char sChar = source.charAt(i);
            sMap.put(sChar,sMap.getOrDefault(sChar,0)+1); // put frequency in map of each character.
            char pChar=pattern.charAt(i);
            pMap.put(pChar,pMap.getOrDefault(pChar,0)+1); // put pattern frequency in map of each character.
        }

        int i=pattern.length();
        int count=0;
        String index="";

        while (i<source.length()){
            if (compareMapFrequency(pMap, sMap)){
                count++;
                index += i-pattern.length()+" ";
            }
            // acquire one from source and
            char chAquire =source.charAt(i);
            sMap.put(chAquire,sMap.getOrDefault(chAquire,0)+1);
            // release one from source
            char chRelease = source.charAt(i-pattern.length());
            if (sMap.get(chRelease)==1){
                sMap.remove(chRelease);
            }else {
                sMap.put(chRelease,sMap.get(chAquire)-1);
            }
            i++;
        }
        if (compareMapFrequency(pMap, sMap)){
            count++;
            index += i-pattern.length()+" ";
        }

        System.out.println(count);
        System.out.println(index);

    }

    private static boolean compareMapFrequency(HashMap<Character, Integer> pMap, HashMap<Character, Integer> sMap) {
        for (Character ch:pMap.keySet()){
            if (!Objects.equals(pMap.getOrDefault(ch, 0), sMap.get(ch))){
                return false;
            }
        }

        return true;
    }
}
