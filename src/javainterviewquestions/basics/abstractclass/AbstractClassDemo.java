package javainterviewquestions.basics.abstractclass;

public abstract class AbstractClassDemo {

    static {
        System.out.println("Abstract class static block");
    }
    public AbstractClassDemo(){
        System.out.println("Abstract class constructor");
    }

    {
        System.out.println("Abstract class init block");
    }
}
