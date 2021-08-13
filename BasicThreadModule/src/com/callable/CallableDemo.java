package com.callable;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 *  JDK5.0新增
 *  call()可以有傳回值
 *  call()可以拋出異常
 *  Callable支援泛型
 */

public class CallableDemo {
    public static void main(String[] args) {
        //建立實現介面的物件
        numSum numSum = new numSum();
        //將此物件作為建構子傳到FutureTask中
        FutureTask<Integer> integerFutureTask = new FutureTask<Integer>(numSum);
        //由於FutureTask有實現 runnable 可以當作thread的建構子，建立並呼叫start()
        new Thread(integerFutureTask).start();

        //如果要拿到傳回值
        try {
            Integer integer = integerFutureTask.get();
            System.out.println(integer);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

    }
}

class numSum implements Callable{

    @Override
    public Integer call() throws Exception {
        Integer sum = 0;
        for (int i = 1; i < 50; i++) {
            if (i%2 ==0){
                i++;
                sum+=i;
            }
        }

        return sum;
    }
}



