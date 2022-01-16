package string;

/**
 * Write a program to reverse an array or string
 * Input  : arr[] = {1, 2, 3}
 * Output : arr[] = {3, 2, 1}
 *
 * Input :  arr[] = {4, 5, 1, 2}
 * Output : arr[] = {2, 1, 5, 4}
 *
 * Input : "AMANDEEP"
 * Output: "PEEDNAMA"
 * */

public class ReverseString {

    public static void main(String[] args) {

        System.out.println(reverseString("amandeep"));
        System.out.println(reverseStringUsingSubString("amandeep"));
    }

    static String reverseString(String s){
        System.out.println("String is "+s);
        char[] array=s.toCharArray();
        int len=array.length;
        for (int i = 0; i <len/2 ; i++) {
            char temp=array[len-(i+1)];
            array[len-(i+1)]=array[i];
            array[i]=temp;
        }
        return new String(array);

    }

    // Using recursion
    static String reverseStringUsingSubString(String s){
        int n=s.length();
        if(n==0){
            return "";
        }else {
            return s.substring(n-1) +reverseStringUsingSubString(s.substring(0,n-1));
        }
    }
}
