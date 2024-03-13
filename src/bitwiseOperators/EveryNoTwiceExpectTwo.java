package bitwiseOperators;

public class EveryNoTwiceExpectTwo {

    public static void main(String[] args) {
        int arr[]={5,4,1,4,3,5,1,2};
        findBothNoOccurredOnce(arr);
    }

    private static void findBothNoOccurredOnce(int[] arr) {
        int xorRes = 0;
        for (int i =0 ; i<arr.length;i++){
            xorRes = xorRes ^ arr[i];
        }
        int x =0;
        int y=0;
        int rightMostBit = xorRes & -xorRes;
        for (int i = 0; i <arr.length ; i++) {
            if((arr[i] & rightMostBit)==0){
                x= x^arr[i];
            }else{
                y = y^arr[i];
            }
        }

        System.out.println(" X "+x+" Y "+y);
    }
}
