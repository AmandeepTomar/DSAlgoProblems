package recursion;
/**
 * Step1 base case
 * Step2 find the relation between problem and sub Problem.
 * Generalize the relation
 * */
public class RecursionApproach {

    public static void main(String[] args) {
        int num=10;
        System.out.println(printNNumbers(num));
        System.out.println("Find Sum of N natural Numbers "+findSumOfNNaturalNo(4));
        System.out.println("Find Pow of a,b "+findPowerOfNum(2,4));
        printPowerSetOfString("abc",0,"");
    }

    /**
     * Break i =n two part and inclue and not include
     *                          abc
     *
     *              a(include)       ""(Not Include)
     *          ab             a       b           ""
     *      abc     ab       ac  a  bc   b        c   ""

     *
     * */
    private static void printPowerSetOfString(String abc ,int start , String current) {

        if (start==abc.length()){
            System.out.println(current);
            return ;
        }
         printPowerSetOfString(abc,start+1,current+abc.charAt(start));
         printPowerSetOfString(abc,start+1,current);


    }

    private static int findPowerOfNum(int num, int pow) {
        if (pow==0){
            return 1;
        }
        return num*findPowerOfNum(num,pow-1);
    }

    private static int findSumOfNNaturalNo(int num) {
        if (num==1){
            return 1;
        }
        return num + findSumOfNNaturalNo(num-1);
    }

    private static int printNNumbers(int num) {
        // STEP 1 base case
        if (num==0) {
            return num;
        }
        System.out.println(num);
        return printNNumbers(num-1);

    }
}
