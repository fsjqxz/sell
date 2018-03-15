package org.fsj.demo;

public class ThreadTest extends  Thread {
    private String name;
    public ThreadTest(String name) {
        this.name=name;
    }

    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println(name + "运行  :  " + i);
            try {
                sleep((int) Math.random() * 10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}
