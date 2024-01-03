package javainterviewquestions;


// define the overriding , inheritance and run time polymorphism.


class SuperA {

    public void publicMethod(){
        System.out.println("publicMethod");
    }

    protected void protectedMethod(int value ,String data){
        System.out.println("protectedMethod value "+value+" data "+data);
    }
}

class ChildOfA extends SuperA{

    @Override
    protected void protectedMethod(int value, String data) {
        super.protectedMethod(value, data);
        System.out.println("child protectedMethod");
    }

    @Override
    public void publicMethod() {
        super.publicMethod();
        System.out.println("Child publicMethod");
    }
}

class ChildOfAResctictionCheck extends SuperA{

    @Override
    public void publicMethod() {
        super.publicMethod();
        System.out.println("Child publicMethod");
    }

    @Override
    public void protectedMethod(int value, String data) {
        super.protectedMethod(value, data);
    }
}
