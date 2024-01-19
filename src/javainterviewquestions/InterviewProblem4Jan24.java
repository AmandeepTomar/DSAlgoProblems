package javainterviewquestions;

public class InterviewProblem4Jan24 {

    public static void main(String[] args) {
        question1("success");
        question2();
    }

    private static void question2() {
        int a=2;
        int coef = 1;

        for (int i = 0; i <a ; i++) {
            for (int j = 0; j < a-i; j++) {
                System.out.println("a");
            }
            for (int j = 0; j <= i; j++) {
                if (i==0 || j==0){  //
                    coef = 1;
                }else{
                    coef = coef*(i-j+1)/j;
                }
            }
        }

        System.out.println(coef);
    }

    private static void question1(String success) {
        int count=0;
        char[] arr = success.toCharArray();
        for (int i = 0; i <arr.length ; i++) {
            for (int j=i+1;j<arr.length;j++){
                if(arr[i]==arr[j]){
                    System.out.print(arr[i]);
                    count++;
                    break;
                }
            }
        }
        System.out.println();
    }
}
