package com.threadCommunity;

/**
 * 3個方法
 * wait() 一旦執行此方法，當前線程進入堵塞，並釋放同步監視器
 * notify() 一旦執行此方法，就會喚醒被wait的線程。如果多個線程處於wait狀態則會喚醒優先度最高的
 * notifyAll() 喚醒所有wait狀態的線程
 *
 * 注意 1.三種方法用在線程通信時，只能出現在同步方法或是同步block裡面(不能用lock)
 *     2.以下的方法都是透過this來調用，也就是都用同一個同步監視器，以及用其呼叫方法
 *       若是sync同步監視器與調用方法的同步監視器不一致，會有錯誤
 *     3.這三個方法定義在Object中
 */
class Num implements Runnable{

    int number = 1;

    @Override
    public void run() {

        while (true){
            synchronized (this){
                //透過此方式來喚醒堵塞的值型緒
                notify();

                if(number <=100){
                    System.out.println(Thread.currentThread().getName()+":"+number++);
                }else{
                    break;
                }
                //調用wait()讓執行續堵塞 如同加了一個鎖上去，如果沒有解開執行續就會一直處於堵塞狀態
                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }


        }

    }
}


public class ThreadCommunication {
    public static void main(String[] args) {
        Num num = new Num();
        Thread t1 = new Thread(num);
        Thread t2 = new Thread(num);

        t1.start();
        t2.start();
    }

}
