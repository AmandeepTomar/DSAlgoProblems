package HackerrankProblems;

public class RepeatedStringProblem {

    public static void main(String[] args) {

        System.out.println(repeatedString("aba",10));
        System.out.println(repeatedString("abbb",1000000000));
    }

    public static long repeatedString(String s, long n) {
        // Write your code here
        int strLength=s.length();
        long q=n/strLength;
        long r=n%strLength;

        long count=q*getStringCount(s,strLength)+getStringCount(s,r);
        return count;

    }

    private static long getStringCount(String s,long length){
        long count=0;
        for(int i=0;i<length;i++){
            if(s.charAt(i)=='a'){
                count++;
            }
        }
        return count;
    }
}
