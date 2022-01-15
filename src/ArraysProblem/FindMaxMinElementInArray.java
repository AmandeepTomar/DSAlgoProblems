package ArraysProblem;

public class FindMaxMinElementInArray {

    public static void main(String[] args) {
        int array[]={1,2,3,4,5,8,9,2,10};

        MAXMIN maxmin=getMaxMin(array,0,array.length-1);

        System.out.println(maxmin.toString());

        int arr[] = {1000, 11, 445, 1, 330, 3000};

        MAXMIN maxmin1=getMaxMin(arr,0,arr.length-1);

        System.out.println(maxmin1.toString());



    }

    static MAXMIN getMaxMin(int [] arr,int low,int high){
        MAXMIN maxmin=new MAXMIN();
        MAXMIN left=new MAXMIN();
        MAXMIN right=new MAXMIN();
        // when low == high==0 {10}
        if(high==low){
            maxmin.max=arr[low];
            maxmin.min=arr[low];
            return maxmin;
        }
        // when high==1 , low=0+1; {10,20}
        if (high==low+1){
            if (arr[low]<arr[high]){
                maxmin.min=arr[low];
                maxmin.max=arr[high];
            }else {
                maxmin.min=arr[high];
                maxmin.max=arr[low];
            }
            return maxmin;
        }

        // if we have more than two elements
        int mid=(low+high)/2;
        right=getMaxMin(arr,mid+1,high);
        left=getMaxMin(arr,0,mid-1);

        if (right.min<left.min){
            maxmin.min= right.min;
        }else {
            maxmin.min= left.min;
        }

        if (right.max> left.max){
            maxmin.max= right.max;
        }else {
            maxmin.max=left.max;
        }
        return maxmin;
    }


}

class MAXMIN{
    int max;
    int min;

    @Override
    public String toString() {
        return "MAXMIN{" +
                "max=" + max +
                ", min=" + min +
                '}';
    }
}
