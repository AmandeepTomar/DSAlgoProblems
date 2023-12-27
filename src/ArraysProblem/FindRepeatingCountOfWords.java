package ArraysProblem;

import java.util.HashMap;

public class FindRepeatingCountOfWords {
    public static void main(String[] args) {
        System.out.println(repeatedString("abcancaabb"));
    }

    public static long repeatedString(String s) {
        // Write your code here
        HashMap<String,Integer> map=new HashMap<>();
        for(char c : s.toCharArray()){
            if(map.containsKey(c+"")){
                int value=map.get(c+"");
                map.put(c+"",value+1);
            }else{
                map.put(c+"",1);
            }
        }

        int value=map.get("a");

        return value;

    }
}
