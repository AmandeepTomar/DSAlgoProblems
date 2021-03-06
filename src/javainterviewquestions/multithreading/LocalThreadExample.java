package javainterviewquestions.multithreading;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;


class PerThreadFormatter {

    private static final ThreadLocal<SimpleDateFormat> dateFormatHolder = new ThreadLocal<SimpleDateFormat>() {

        /*
         * initialValue() is called
         */
        @Override
        protected SimpleDateFormat initialValue() {
            System.out.println("Creating SimpleDateFormat for Thread : " + Thread.currentThread().getName());
            return new SimpleDateFormat("dd/MM/yyyy");
        }
    };


    private static final ThreadLocal<Integer> count=new ThreadLocal<>(){
        @Override
        protected Integer initialValue() {
            return 10;
        }
    };

    /*
     * Every time there is a call for DateFormat, ThreadLocal will return calling
     * Thread's copy of SimpleDateFormat
     */
    public static DateFormat getDateFormatter() {
        return dateFormatHolder.get();
    }
}



class Task implements Runnable{

    @Override
    public void run() {
        for(int i=0; i<2; i++){
            System.out.println("Thread: " + Thread.currentThread().getName() + " Formatted Date: " + LocalThreadExample.threadSafeFormat(new Date()) );
        }
    }
}


public class LocalThreadExample {

    public static void main(String args[]) throws IOException {
        Thread t1 = new Thread(new Task());
        Thread t2 = new Thread( new Task());

        t1.start();
        t2.start();


    }

    /*
     * Thread safe format method because every thread will use its own DateFormat
     */
    public static String threadSafeFormat(Date date){
        DateFormat formatter = PerThreadFormatter.getDateFormatter();
        return formatter.format(date);
    }

}
