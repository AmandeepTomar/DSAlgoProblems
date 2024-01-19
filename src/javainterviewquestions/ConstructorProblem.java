package javainterviewquestions;


class Test{
    private static int  counter=0;
    void Test(){ // act as method
        counter=20;
    }

    Test(int x){
        counter=x;
    }
}

public class ConstructorProblem {

    public static void main(String[] args) {
      //  Test test=new Test(); // compile error
    }
}
