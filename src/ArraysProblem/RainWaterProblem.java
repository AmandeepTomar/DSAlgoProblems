package ArraysProblem;


/**
 *
 * Input => {3,1,2,4,0,1,3,2}
 * Out put is 3+5 =>8
 * 2+1+3+2
 *ALGO
 * Used Array Pre processing
 * */
public class RainWaterProblem {
    public static void main(String[] args) {
        int [] arr={3,1,2,4,0,1,3,2};
        rainWatre(arr);
    }

    private static void rainWatre(int[] arr) {
        //Steps -> Pre process Array
        // left Math.max(arr[i+1],arr[i])
        // right Math.max()-> from right

    }
}
