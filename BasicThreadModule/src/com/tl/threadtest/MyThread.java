package com.tl.threadtest;

/**
 *    繼承thread
 *    重寫run
 *    建立物件
 */
public class MyThread extends Thread {
    boolean OddOrEven = false;

    public MyThread(boolean boo) {
        this.OddOrEven = boo;
    }

    @Override
    public void run() {
        if (OddOrEven) {
            for (int i = 1; i <= 100; i++) {
                if (i % 2 == 0) {
                    System.out.println(Thread.currentThread().getName());
                    System.out.println("thread1: " + i);
                }
            }
        } else {
            for (int i = 1; i <= 100; i++) {
                if (i % 3 == 0) {
                    System.out.println("thread2: " + i);
                }
            }

        }
    }
}

