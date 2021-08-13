package com.TheadPool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

class Num implements Runnable{

    @Override
    public void run() {
        for (int i = 0; i <=10 ; i++) {
            System.out.println(Thread.currentThread().getName()+"："+i);
        }
    }
}

public class ThreadPool {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        ThreadPoolExecutor service = (ThreadPoolExecutor) executorService;
        //利用其類別ThreadPoolExecutor來設定屬性
        service.setCorePoolSize(8);

        //executorService.submit(); //用於callable
        executorService.execute(new Num()); //用於runnable
        //記得關閉線程池
        executorService.shutdown();
    }
}
