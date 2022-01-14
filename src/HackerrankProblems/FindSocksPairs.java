package HackerrankProblems;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class FindSocksPairs {

    /**
     * HackerRank
     * There is a large pile of socks that must be paired by color. Given an array of integers representing the color of each sock, determine how many pairs of socks with matching colors there are.
     *
     * Example
     *
     *
     * There is one pair of color  and one of color . There are three odd socks left, one of each color. The number of pairs is .
     *
     * Function Description
     *
     * Complete the sockMerchant function in the editor below.
     *
     * sockMerchant has the following parameter(s):
     *
     * int n: the number of socks in the pile
     * int ar[n]: the colors of each sock
     * Returns
     *
     * int: the number of pairs
     * Input Format
     *
     * The first line contains an integer , the number of socks represented in .
     * The second line contains  space-separated integers, , the colors of the socks in the pile.
     *
     * Constraints
     *
     *  where
     * Sample Input
     *
     * STDIN                       Function
     * -----                       --------
     * 9                           n = 9
     * 10 20 20 10 10 30 50 10 20  ar = [10, 20, 20, 10, 10, 30, 50, 10, 20]
     * */

    public static void main(String[] args) {
      //  10 20 20 10 10 30 50 10 20
        List<Integer> ar=new ArrayList<>();
        ar.add(10);
        ar.add(20);
        ar.add(20);
        ar.add(10);
        ar.add(10);
        ar.add(30);
        ar.add(50);
        ar.add(10);
        ar.add(20);

        System.out.println(sockMerchant(ar.size(),ar));
    }


    public static int sockMerchant(int n, List<Integer> ar) {
        // Write your code here
        HashMap<Integer,Integer> map=new HashMap<>();
        for(Integer i : ar){
            if(map.containsKey(i)){
                Integer value=map.get(i);

                map.put(i,value+1);
            }else{
                map.put(i,1);
            }
        }
        int pair=0;
        for (Integer key : map.keySet()){

            Integer value=map.get(key);
            int mod=value/2;
            pair=pair+mod;

        }

        return pair;


    }
}
