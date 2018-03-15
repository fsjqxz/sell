package org.fsj.demo;

public class  RunnableTest implements Runnable {


        private String name;
        public RunnableTest(String name) {
            this.name=name;
        }

        @Override
        public synchronized void run() {
            for (int i = 0; i < 9999; i++) {
                System.out.println(name + "运行  :  " + i);

               /* try {
                    sleep((byte) Math.random() * 10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }*/
            }

        }


    }


