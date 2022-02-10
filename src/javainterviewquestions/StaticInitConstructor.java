package javainterviewquestions;

/**
 * if we call simple class
 * this one is sequence , static block , init block and constructor
 * Static block called
 * Init block
 * Constructor called
 *
 * If we have all methods in both class super and manin
 * class A extends B
 * Sequences are
 * SuperSample Static block called
 * Static block called
 * SuperSample Init block
 * SuperSample Constructor called  // first call super class constructor
 * Init block
 * Constructor called
 * */
public class StaticInitConstructor {

    public static void main(String[] args) {
        SampleTest sampleTest=new SampleTest();

    }
}

class SampleTest extends SuperSample {

    public SampleTest() {
        super();
        System.out.println("Constructor called");
    }

    {
        System.out.println("Init block");
    }

    static {
        System.out.println("Static block called");
    }
}

class SuperSample{

    public SuperSample() {
        System.out.println("SuperSample Constructor called ");
    }

    {
        System.out.println("SuperSample Init block");
    }

    static {
        System.out.println("SuperSample Static block called");
    }
}
