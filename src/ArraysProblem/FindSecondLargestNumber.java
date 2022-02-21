package ArraysProblem;

public class FindSecondLargestNumber {

    public static void main(String[] args) {
        int arr[]={12, 35, 1, 10, 34, 1};

        System.out.println(findSecondLargestNumber(arr));
        System.out.println(findSecondSmallestNumber(arr));



    }

    private static int findSecondLargestNumber(int[] arr) {
        int first=Integer.MIN_VALUE;
        int second=-1;
        for (int i = 0; i <arr.length ; i++) {
            if (arr[i]>first){
                second=first;
                first=arr[i];
            }else if (arr[i]>second && arr[i]!=first){
                second=arr[i];
            }
        }
        return second;
    }


    private static int findSecondSmallestNumber(int arr[]){
        int first=Integer.MAX_VALUE;
        int second=-1;

        for (int i = 0; i <arr.length; i++) {
            if (arr[i]<first){
                second=first;
                first=arr[i];
            }else if (arr[i]<second && arr[i]!=first){
                second=arr[i];
            }
        }
        return second;
    }
}
