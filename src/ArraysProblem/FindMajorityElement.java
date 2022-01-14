package ArraysProblem;

import java.util.Arrays;

public class FindMajorityElement {

    /**
     * Given an array of size n, find the element which occurs more than n/2 times. This element is called Majority Element.
     *
     * For example:
     * Array 1: {2 6 2 2 6 2 2 8 2 1}
     * */

    public static void main(String[] args) {
        int[] array = new int[]{4,7,4,4,7,4,4,9,4,3};
        findMajorityOfElementWithBestOne(array);
        findMajorityWithN2Complexity(array);
    }


    static void findMajorityOfElementWithBestOne(int[] array){
        Integer item=null;
        int count=0;
        for (int i=0;i<array.length;i++){
            if (count==0){
                item=array[i];
                count=1;
                continue;
            }else {
                if (item==array[i]){
                    count++;
                }else {
                     count--;
                }
            }
        }
        System.out.println("Mojority item is "+item+" It occur"+count+" Times");
    }


    static void findMajorityWithN2Complexity(int[] array){
        int count=0;
        for (int i = 0; i <array.length ; i++) {
            for (int j = i; j <array.length ; j++) {
                if (array[i]==array[j]){
                    count++;
                }
                if (count>=array.length/2){
                    System.out.println("Item is "+array[i]+" Times "+count);
                    return;
                }
            }
        }
    }
}
