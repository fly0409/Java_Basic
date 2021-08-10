package com.tl.threadtest;

public class ThreadTest {
    public static void main(String[] args) {
        //這裡是主要的執行續處理的
        MyThread t1 = new MyThread(true);
        MyThread t2 = new MyThread(false);
        //調用start方法，也是主要的執行續處理的
        //t1是主線呈建立的 但建立了之後便獨立了出來
        //啟用當前線程，調用run
        t1.start(); //如果調用run()?=>就不是多線程
        t2.start();
        //這裡是主要的執行續處理的
        for(int i = 1 ; i<=100;i++){
            if(i%2 == 0){
                System.out.println("mainThread"+i);
            }
        }
    }
}
