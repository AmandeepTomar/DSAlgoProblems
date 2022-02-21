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
        System.out.println(majorityElement(array,array.length));
    }

    // Fit in all situation  this one is correct for long input

    static int majorityElement(int a[], int size)
    {

        //Take the first elem as the majority elem
        //count variable will be the count for our majority variable
        int majorityIndex = 0;
        int count = 1;

        for(int i = 1; i < size; i++){
            if(a[i] == a[majorityIndex]){
                //if we are getting more count for our taken majority variable
                //then it might me the answer
                count++;
            }else{
                //decrease the preference for our majority variable
                count--;
            }

            if(count == 0){
                //We'll take curr elem as our majority elem
                //when the count for our previous majority elem becomes 0
                majorityIndex = i;
                count = 1;
            }
        }

        //Check if the last majority elem is actually our answer or not
        if(count > 0){
            int new_count = 0;
            for(int i = 0; i < size; i++){
                if(a[i] == a[majorityIndex])
                    new_count++;
            }

            if(new_count > (int)size/2)
                return a[majorityIndex];

        }

        //if the count for our last majority elem is 0, then no majority elem exists
        return -1;

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
