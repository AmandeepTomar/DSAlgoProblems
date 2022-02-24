package ArraysProblem;


import java.util.HashMap;

/**
 * you Have given string you need to print the String as the Occurrence in sequence
 *
 * Input aabbccddeee;
 * Output e -> 3 times
 *
 * Input aabbcc
 * output a -> 2times
 * */

public class FindMaximumOccuranceInString {

    public static void main(String[] args) {
        String s="aabbccddee";
        String s1="aabbccddeee";

        solution(s);
        solution(s1);
    }

    private static void solution(String s){
        int max=0;
        String result="";
        HashMap<Character,Integer> map=new HashMap();
        for (int i = 0; i <s.length(); i++) {
            char key=s.charAt(i);
            if (map.containsKey(key)){
                int value=map.get(key)+1;
                map.put(key,value);
            }else {
                map.put(key,1);
            }
        }

        for(Character ch:map.keySet()){
            if (max<map.get(ch)){
                max=map.get(ch);
                result=ch.toString();
            }

        }

        System.out.println("Char is "+result+" Times "+max);

    }
}
