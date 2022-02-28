package ArraysProblem;

public class FindPrimeNumber {

    public static void main(String[] args) {
        int num1=100;
        int num2=1000;
        findPrimeNumbers(num1,num2);
    }

    private static void findPrimeNumbers(int num1, int num2) {
        StringBuilder sb = new StringBuilder();
        int num=0;
        for (int i = num1; i <num2 ; i++) {
            int count=0;
            // here is like we check for 100 and check
            // i =100 and check modulas from 100 to 1. or if we get count==2 then add.
            for (num = i; num >=1 ; num--) {
                if (i%num==0){
                    count +=1;
                }
            }
            if (count==2){
                System.out.println("count Value "+count);
                sb.append(i).append(" ");
            }

        }
        System.out.println("Prime Numbers are "+sb.toString());
    }
}
