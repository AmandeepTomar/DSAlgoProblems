package javainterviewquestions.multithreading;

import java.util.concurrent.atomic.AtomicInteger;

public class MultiThreadingProblem {



    public static void main(String[] args) {

        for (int i = 0; i <250 ; i++) {

            Counter counter=new Counter();

            Thread t1=new Thread(new Runnable() {

                @Override
                public void run() {
                    for (int i = 0; i <100000 ; i++) {
                        counter.updateCount();
                    }

                }
            });

            Thread t2=new Thread(new Runnable() {

                @Override
                public void run() {
                    for (int i = 0; i <100000 ; i++) {
                        counter.updateCount();
                    }

                }
            });

            t1.start();
            t2.start();
            try {
                t1.join();
                t2.join();
            }catch (Exception e){
                System.out.println(e);
            }

            System.out.println(" Counter for "+i+"the ="+counter.count.get());
        }
    }


}



class Counter{
     AtomicInteger count=new AtomicInteger(0);

    public int getCount() {
        return count.get();
    }

    public void updateCount() {
//        synchronized(this){
            count.incrementAndGet();
//        }

    }
}
