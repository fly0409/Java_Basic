package com.tl.threadtest;

public class ThreadTest2 {
    public static void main(String[] args) {
        //這裡是主要的執行續處理的
        MyThread t1 = new MyThread(true);

        t1.start(); //如果調用run()?=>就不是多線程
        //use Thread.currentThread().getName() to check Thread name
        //t1.run();

        //start thread again=>java.lang.IllegalThreadStateException
        //t1.start();
        // one thread only can start once

        for(int i = 1 ; i<=100;i++){
            if(i%2 == 0){
                System.out.println(Thread.currentThread().getName());
                System.out.println("main： "+i);
            }
        }

    }
}
