package string;

import java.util.ArrayList;
import java.util.List;

public class StringPermutationProblem {

    public static void main(String[] args) {
        List<String> list=new ArrayList<>();
        list.add(null);

        String str="abc";
        System.out.println(str.substring(1));

        int left=0;
        int right=str.length()-1;
    //    findStringPermutation(str,left,right);
        System.out.println();
        findStringPermutationUsingSubstring(str,"");
    }

    private static void findStringPermutationUsingSubstring(String str, String result) {
        if (str.length()==0){
            System.out.println(result+" ");
            return;
        }
        for (int i=0;i<str.length();i++){
            char ch =str.charAt(i);   
            String left=str.substring(0,i);
            System.out.println("Left "+left);
            String right=str.substring(i+1);
            System.out.println("Right "+right);

            String rest=left+right;
            findStringPermutationUsingSubstring(rest,result+ch);
        }
    }

    private static void findStringPermutation(String str , int left, int right) {

        if (left == right)
            System.out.println(str);
        else
        {
            for (int i = left; i <= right; i++)
            {
                str = swapTwoInStr(str,left,i);
                findStringPermutation(str, left+1, right);
                str = swapTwoInStr(str,left,i);
            }
        }
    }

    private static String swapTwoInStr(String str, int left, int i) {
        char [] array=str.toCharArray();
        char temp=array[left];
        array[left]=array[i];
        array[i]=temp;
        return String.valueOf(array);
    }


}
