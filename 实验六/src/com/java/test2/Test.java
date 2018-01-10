package com.java.test2;

public class Test {
    public static int sum = 0;
    public static Object LOCK = new Object();


    public static void main(String[] args) throws InterruptedException {
        Test add = new Test();
        ThreadTest thread1 = add.new ThreadTest(1, 25);
        ThreadTest thread2 = add.new ThreadTest(26, 50);
        ThreadTest thread3 = add.new ThreadTest(51, 75);
        ThreadTest thread4 = add.new ThreadTest(76, 100);
        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();

         thread1.join();
         thread2.join();
         thread3.join();
         thread4.join();
         System.out.println("total result: "+sum);
    }

    class ThreadTest extends Thread {
        private int begin;
        private int end;

        @Override
        public void run() {
            synchronized (LOCK) {
                for (int i = begin; i <= end; i++) {
                    sum += i;
                }
                System.out.println("from "+Thread.currentThread().getName()+" sum="+sum);
            }
        }

        public ThreadTest(int begin, int end) {
            this.begin = begin;
            this.end = end;
        }
    }
}