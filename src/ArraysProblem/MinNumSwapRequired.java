package ArraysProblem;

public class MinNumSwapRequired {
    public static void main(String[] args) {

      //  int arr[]={1,2,5,3,7};
        int arr[]={1,2,5,6,7,3};
        int k=2;
        minimumSwapRequiredToBringSwapTogether(arr,k);
    }


    private static void minimumSwapRequiredToBringSwapTogether(int[] arr, int k) {
        int good=0;
        int bad=0;
       // int arr[]={1,2,5,3,7};
        // calculate good values in array
        for (int i = 0; i <arr.length ; i++) {
            if (arr[i]<=k){
                good++;
            }
        }

        // calculate bad values in the window
        for (int i = 0; i <good ; i++) {
            if (arr[i]>k){
                bad++;
            }
        }

        System.out.println("Good "+good+" Bad "+bad);

        int result=bad;
        int i=0;
        int j=good;
        while (j<arr.length){
            if (arr[i]>k){
                bad--;
            }else if (arr[j]>k){
                bad++;
            }
            result=Math.min(result,bad);
            i++;
            j++;
        }

        System.out.println("Min Number of Swap required is "+result);
    }

}
