package ArraysProblem;


import java.util.Arrays;

import static ArraysProblem.Sort0s1sand2sWithoutSorting.swap;

public class MoveNegativeElementOneSide {

    public static void main(String[] args) {
        int arr[]={-1,1,-2,2,3,-5,5,6,7,8,-7,9};

      //  approach1(arr);
    //    approach2(arr);
        approach3(arr);
        //approach4(arr);
        rearrange(arr,arr.length);
    }


// correct one
    static void rearrange(int arr[], int n)
    {
        int j = 0, temp;
        for (int i = 0; i < n; i++) {
            // if positive no need to increase j
            if (arr[i] < 0) {
                if (i != j) {
                    // swap
                    temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
                j++;
            }
        }
        System.out.println(Arrays.toString(arr));;
    }

    private static void approach1(int[] arr) {
        // 1. sort Array
        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));
        System.out.println("========================");


        // this way we can just sort the array
    }

    private static void approach2(int arr[]){
        // Steps we compare with 0 and put the +ve in one array and negative in another array and merge them.
        int [] posArray=new int[arr.length];
        int [] negArray=new int[arr.length];
        int posCounter=0;
        int negCounter=0;

        for (int i = 0; i <arr.length; i++) {
            if (arr[i]>=0){
                posArray[posCounter]=arr[i];
                posCounter++;
            }else {
                negArray[negCounter]=arr[i];
                negCounter++;
            }
        }

        System.out.println(Arrays.toString(posArray));
        System.out.println(Arrays.toString(negArray));

        System.out.println(posCounter+"---"+negCounter);

        for (int i = 0; i <arr.length ; i++) {
            if (i<negCounter){
                arr[i]=negArray[i];
            }else {
                arr[i]=posArray[i-posCounter];
            }
        }
        System.out.println(Arrays.toString(arr));
        System.out.println("========================");

    }


    static void approach3(int arr[]){
        // in this approach we will use the two pointer and swaping
        // i and j
      //  int arr[]={-1,1-2,2-3,-5,5,6,7,8,-7,9}; i=0,j=11
        int j=arr.length-1;
        for (int i = 0; i <arr.length ; i++) {
            if (arr[i]<0){
                i++;
            }else {
                swap(arr,i,j);
                System.out.println(Arrays.toString(arr));
                j--;
               // i++;
            }
        }

        System.out.println(Arrays.toString(arr));
        System.out.println("======================== 3");

    }




    static void approach4(int arr[]){
        int left=0;
        int right=arr.length-1;
        while(left<=right){

            if (arr[left]<0 && arr[right]<0){
                left++;
            }else if (arr[left] >=0 && arr[right]<0){
                swap(arr,left,right);
                left++;
                right--;
            }else if (arr[left]>0 && arr[right]>0){
                right--;
            }
        }

        System.out.println(Arrays.toString(arr));
        System.out.println("========================4");
    }
}
