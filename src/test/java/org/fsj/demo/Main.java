package org.fsj.demo;

public class Main {

    public static void main(String[] args) {

        RunnableTest thread1 = new RunnableTest("一号");
        Thread t1 = new Thread(thread1);
        RunnableTest thread2 = new RunnableTest("二号");
        Thread t2 = new Thread(thread2);

   // t2 = t1;
        t1.start();
        t2.start();



        /***********继承Tread************/
       // Thread t3   = new ThreadTest("t3");
       // t3.start();

    }
}
