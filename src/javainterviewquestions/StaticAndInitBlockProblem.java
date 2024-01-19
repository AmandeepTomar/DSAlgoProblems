package javainterviewquestions;


/**
 * L1 ->
 *
 * i = i-- - --i;
 * i = 1111 - 1109 = 2
 * L2 ->
 *
 * i = i++ + ++i;
 * i = 0 + 2 = 2
 * L3 ->
 *
 * i = --i - i--;
 * i = 1 - 1 = 0
 * L4 ->
 *
 * i = ++i + i++;
 * i = 3 + 3 = 6 = y.i
 * L5 ->
 * y.i = i from class Y which is 6.
 * Hence the output is 6.
 * */
class X {
    static int i = 1111;

    static{
        i = i-- - --i;    //L1 -2
    }

    {
        i = i++ + ++i;    //L2 // +2
    }
}

class Y extends X{
    static{
        i = --i - i--;    //L3 -1
    }
    {
        i = ++i + i++;    //L4  +1
    }
}

public class StaticAndInitBlockProblem {

    public static void main(String[] args){
        Y y = new Y();
        System.out.println(y.i);    //L5
    }
}


