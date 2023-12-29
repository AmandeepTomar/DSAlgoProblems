package javainterviewquestions.basics.abstractclass;

public class ClassA  extends AbstractClassDemo {

    static {
        System.out.println("Class A static");
    }
    public ClassA(){
        System.out.println("Class A constructor");
    }

    {
        System.out.println("Class A init");
    }
}
