package javainterviewquestions.regularexpression;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegularExpression {

    public static void main(String[] args) {
        checkDigit("amandeep");
        checkDigit("amandeep123");
        checkDigit("amand23eep");
    }

    private static void checkDigit(String s) {
        String regex = "(.)*(\\d)(.)*";
        Pattern pattern1=Pattern.compile(regex);
        Matcher matcher=pattern1.matcher(s);
       boolean match= matcher.matches();
       if (match){
           System.out.println("hash digit");
       }else {
           System.out.println("No digits");
       }
    }
}
