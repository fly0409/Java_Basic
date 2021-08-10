package com.tai.test;

public class WindowTest {
    public static void main(String[] args) {
        Windows w1= new Windows();

        Thread t1 = new Thread(w1);
        Thread t2 = new Thread(w1);
        Thread t3 = new Thread(w1);

        t1.start();
        t2.start();
        t3.start();
    }
}


class Windows implements Runnable{

    int count = 100;

    @Override
    public void run() {
        while(true){

            if(count >0){
                System.out.println(Thread.currentThread().getName() +"："+ count);
                count--;
            }else{
                break;
            }
        }
    }
}
