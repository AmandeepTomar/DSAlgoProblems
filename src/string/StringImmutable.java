package string;

public class StringImmutable {

    public static void main(String[] args) {

        String s="Aman";
        String s1=new String("Aman").intern();

        System.out.println("S String hashcode "+s.hashCode());
        System.out.println("S1 String hashcode "+s1.hashCode());

        System.out.println(s==s1);

    }
}
