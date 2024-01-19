package recursion;

public class Reverse_Array_InPlace {

    public static void main(String[] args) {
        String str = "Hello";
        reverserArrayInPlace(str.toCharArray(), 0, "");
    }

    private static void reverserArrayInPlace(char[] charArray, int index, String res) {
        if (index == charArray.length / 2) {
            return;
        }
        reverserArrayInPlace(charArray, index + 1, res);
        res = swapChars(charArray, index, charArray.length - index - 1);

        System.out.println(res);
    }

    private static String swapChars(char[] charArray, int index, int i) {
        char temp = charArray[index];
        charArray[index] = charArray[i];
        charArray[i] = temp;

        return new String(charArray);
    }

}
