package ArraysProblem;

import java.util.Arrays;

public class LeftAndRightRotationProblem {
    public static void main(String[] args) {
//        int arr[]={1,2,3,4,5};
//        int times=4;
//        rightRotationApproach1(arr,times);
//
//        int arr1[]={1,2,3,4,5};
//        rightRotationBestApproach(arr1,times);
//
//
//        int arr2[]={1,2,3,4,5};
//        leftRotationApproach1(arr2,times);
//
//         int arr3[]={1,2,3,4,5};
        //leftRotationBestApproach(arr3,times);

        int [] nums={1,2,3,4,5,6,7};
       // rotate(nums,1);
        gogRotateLeft(new int[]{1,2,3,4,5},2,5);





    }

    private static void gogRotateLeft(int arr[], int d, int n) {
        int newArr[] = new int[n];
        for(int i=0;i<n;i++){
            int newIndex=(i-d)%n;
            newArr[newIndex]=arr[i];
        }

        arr=Arrays.copyOf(newArr,n);
        System.out.println(Arrays.toString(arr));
    }


    public static void rotate(int[] nums, int k) {
        // [1,2,3,4,5,6,7]
        // right rotate -> [2,3,4,5,6,7,1] -> [2,3,4,5,6,7,1,2]->[3,4,5,6,7,1,2,3]

        // left rotate
        //-> [7,1,2,3,4,5,6]-> [6,7,1,2,3,4,5]->[5,6,7,1,2,3,4]
//        for(int i=0;i<k;i++){
//            int temp =nums[nums.length-1];
//            for(int j=nums.length-1;j>0;j--){
//                nums[j]=nums[j-1]; //arr[6]=arr[5];
//            }
//            nums[0]=temp;
//        }

        int arr[]=new int[nums.length];
        int n=nums.length;
        for (int i = 0; i < n ; i++) {
            int newIndex=(i+k)%n;
            System.out.println("new Index "+newIndex+"  CurrentIndex "+i);
           // swap(nums,newIndex,i);
            arr[newIndex]=nums[i];
            System.out.println("Arrays is "+Arrays.toString(arr));
        }
        nums=Arrays.copyOf(arr,arr.length);

        System.out.println("Nums Arr "+Arrays.toString(nums));

    }

    private static void swap(int[] arr, int newIndex , int current){
        System.out.println("Before Swap--,"+"New Index is"+arr[newIndex]+"current"+arr[current]+" = "+Arrays.toString(arr));
        int temp = arr[newIndex];
        arr[newIndex]=arr[current];
        arr[current] = temp;
        System.out.println("After Swap--,"+"New Index is"+arr[newIndex]+"current"+arr[current]+" = "+Arrays.toString(arr));
    }





    private static void rightRotationApproach1(int[] arr, int times) {
        // right rotation means shift one element to the right
        // like 1,2,3,4,5 After one right shift it will be 5,1,2,3,4
        // 2 nd 4,5,1,2,3
        int n=arr.length;

        for (int i = 0; i <times ; i++) {
            int temp=arr[n-1];
            for (int j = n-1; j > 0 ; j--) {
                arr[j]=arr[j-1];
            }
            arr[0]=temp;
        }
        System.out.println("Right rotation of Array"+ Arrays.toString(arr)+"times "+times);
    }

    private static void rightRotationBestApproach(int[] arr,int times){
        int n=arr.length;
        int[] newArray=new int[n];
        for (int i = 0; i <n ; i++) {
            int newIndex=(i+times)%n;
            newArray[newIndex]=arr[i];
        }
        System.out.println("Right rotation of Array"+ Arrays.toString(newArray)+"times "+times);
    }

    private static void leftRotationApproach1(int arr[], int times){
        // Left Rotate means
        // 1,2,3,4,5 -> 2,3,4,5,1
        int n=arr.length;

        for (int i = 0; i <times ; i++) {
            int temp=arr[0];
            for (int j = 0; j <n-1 ; j++) {
                arr[j]=arr[j+1];
            }
            arr[n-1]=temp;
        }
        System.out.println("Left Rotation  "+Arrays.toString(arr)+" times "+times);
    }

    private static void leftRotationBestApproach(int arr[],int times){
        int n=arr.length;
        int newArr[]=new int[n];
        for (int i = 0; i <n ; i++) {
            int newIndex=(i+(arr.length-times)) % arr.length;
            newArr[newIndex]=arr[i];
        }
        System.out.println("Left Rotation "+Arrays.toString(newArr)+" times "+times);
    }






}
