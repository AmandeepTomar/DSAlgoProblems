package ArraysProblem;

public class FindPeekInArray {
    public static void main(String[] args) {
        int[] array = {15, 20, 25, 35, 45, 50, 60};
        int[] array1 = {70, 20, 50, 35, 45, 50, 60};
        int[] array2 = {16, 20, 25, 55, 45, 50, 60};
        int index = findPeekElement(array); // last
        int index1 = findPeekElement(array1); // first
        int index2 = findPeekElement(array2); // middle

        // find peek element is => element is greater than both of its neighbour.


        System.out.println("Find Peek at index " + index + " is " + array[index]);
        System.out.println("Find Peek at index " + index1 + " is " + array1[index1]);
        System.out.println("Find Peek at index " + index2 + " is " + array2[index2]);

        int indexBinary = findPeekElementWithBinarySearch(array); // last
        int index1Binary = findPeekElementWithBinarySearch(array1); // first
        int index2Binary = findPeekElementWithBinarySearch(array2); // middle

        System.out.println("Find Peek by Binary at index " + indexBinary + " is " + array[indexBinary]);
        System.out.println("Find Peek by Binary at index " + index1Binary + " is " + array1[index1Binary]);
        System.out.println("Find Peek by Binary at index " + index2Binary + " is " + array2[index2Binary]);


    }

    static int findPeekElement(int[] array) {
        if (array == null || array.length == 0) {
            return -1;
        }
        for (int i = 0; i < array.length; i++) {
            if (i == 0) {
                if (array[i] >= array[i + 1]) {
                    return i;
                }
            } else if (i == array.length - 1) {
                if (array[i] >= array[i - 1]) {
                    return i;
                }
            } else {
                if (array[i - 1] <= array[i] && array[i] >= array[i + 1]) {
                    return i;
                }
            }
        }
        return -1;
    }

    /**
     * Time complexity o(logn)*/
    static int findPeekElementWithBinarySearch(int[] array) {
        if (array == null || array.length == 0) {
            return -1;
        }
        int start = 0;
        int n = array.length;
        int end = array.length - 1;

        while (start <= end) {
            int mid = (start + end) / 2;

            if ((mid == 0 || array[mid - 1] <= array[mid]) && (mid == array.length - 1 || array[mid] >= array[mid + 1])) {
                return mid;
            } else if (mid > 0 && array[mid - 1] >= array[mid]) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }

        }
        return -1;
    }



}
