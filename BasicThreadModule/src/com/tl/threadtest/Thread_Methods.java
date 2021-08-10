package com.tl.threadtest;

/** 測試Thread常用方法
 *  start()  啟動當前線程 調用 run
 *  run()    需重寫的方法
 *   currnetThread() 當前線程名
 *   getName/SetName
 *   yield() :釋放當前cpu執行權
 *   join()：
 */
class HelloThread extends Thread {
    //利用建構子把線程命名
    public HelloThread(String name) {
        super(name);
    }

    @Override
    public void run() {
        for (int i = 0; i < 50; i++) {
            if (i % 2 == 0) {
                System.out.println(Thread.currentThread().getName() + ":" + i);
                // System.out.println("thread1: " + i);
                if (i % 10 == 0) {
                    //this = > 當前的 線程，等同於Thread.currentThread()
                    this.yield();//釋放當前cpu的資源，讓其他線程用
                }
            }
        }
    }
}

public class Thread_Methods {

    public static void main(String[] args) {
        HelloThread t1 = new HelloThread("lisa");
        t1.start();
        for (int i = 0; i < 50; i++) {
            if (i % 2 == 0) {
                System.out.println(Thread.currentThread().getName() + ":" + i);
                if (i % 10 == 0) {

                }
            }
        }

    }
}


