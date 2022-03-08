package integerproblems;

import java.util.*;

public class ReverseNumber {

    public static void main(String[] args) {
        int num=123;
        reverseInt(num);
        findSmallestAndLargestNumberInInteger(2346);
        findLargestDigitFromNumber(756);


    }

    private static void reverseInt(int num) {
        int number=num;
        int revNo=0;
        while (number>0){
            revNo=revNo*10 + number%10;
            number=number/10;
        }
        System.out.println("Number is ="+num+"Reversed No "+revNo);
    }


    private static void findSmallestAndLargestNumberInInteger(int number){
        int min=Integer.MAX_VALUE;
        int max=0;
        int num=number;

        while (num>0){
            min=Math.min(min,num%10);
            max=Math.max(max,num%10);
            num=num/10;
        }
        System.out.println("Min "+min+" Max "+max+" FROM Number"+number);

    }

    /**
     * Find maximum number that can be formed using digits of a given number
     * Input : 38293367
     * Output : 98763332
     *
     * Input : 1203465
     * Output: 6543210
     * */
    private static void findLargestDigitFromNumber(int number){
        // this one is not the best one
        String num=number+"";
        int numArr[]=new int[num.length()];
        System.out.println("SizeOfArray ="+numArr.length+" -  ");
      //  String num=number+"";
        StringBuilder sb=new StringBuilder();
        List<Integer> list=new LinkedList<>();

        for (int i = 0; i <num.length() ; i++) {
            list.add(Integer.parseInt(num.charAt(i)+""));
        }
        Collections.sort(list,Collections.reverseOrder());
        System.out.println(list+" Maximum");
        Collections.sort(list);
        System.out.println(list+" Minimum");

        for (Integer i:list){
            sb.append(i);
        }

        int minimum=Integer.parseInt(sb.toString());

        System.out.println(" Minimum is "+minimum);
    }



}
