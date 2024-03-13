package javainterviewquestions.multithreading;

import java.util.concurrent.locks.ReentrantLock;

public class PrintSequenceInThreeThread {

    public static void main(String[] args) {
        NumberGenerator numberGenerator = new NumberGenerator(3,10);

        Thread t1 = new Thread(new SequenceGenerator(numberGenerator,1),"Thread-1");
        Thread t2 = new Thread(new SequenceGenerator(numberGenerator,2),"Thread-2");
        Thread t3 = new Thread(new SequenceGenerator(numberGenerator,0),"Thread-3");

        t1.start();
        t2.start();
        t3.start();

    }
}

class SequenceGenerator implements Runnable {
    private NumberGenerator numberGenerator;
    private int index;

    SequenceGenerator(NumberGenerator numberGenerator, int index) {
        this.numberGenerator = numberGenerator;
        this.index = index;
    }

    @Override
    public void run() {
        this.numberGenerator.printNumber(this.index);
    }
}

class NumberGenerator {
    private int currNo = 1;
    private int totalNoOfThreads;
    private int totalNoInSequence;

    NumberGenerator(int totalNoOfThreads, int totalNoInSequence) {
        this.totalNoOfThreads = totalNoOfThreads;
        this.totalNoInSequence = totalNoInSequence;
    }

    public void printNumber(int index) {
        synchronized (this) {
            while (currNo < totalNoInSequence) {
                while (currNo % totalNoOfThreads != index) {
                    try {
                        wait();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                System.out.println(Thread.currentThread().getName() + " : " + currNo++);
                notifyAll();
            }
        }
    }
}

