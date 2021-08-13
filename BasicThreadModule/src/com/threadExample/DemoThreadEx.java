package com.threadExample;

/**
 * 情境 有生產者 產出產品 (倉庫做多只有20個)
 *      有消費者 消耗產品
 *      有店員 在做生產跟消費中間的服務
 */
class Consumer extends Thread{
    private Clerk clerk;

    public Consumer(Clerk clerk){
        this.clerk=clerk;
    }
    @Override
    public void run() {
        while (true){
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            clerk.consume();
        }

    }
}

class Producer extends Thread{
    private Clerk clerk;

    public Producer(Clerk clerk){
        this.clerk=clerk;
    }
    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            clerk.produce();
        }
    }
}

class Clerk{
    private int productCount;

    public synchronized void consume(){
         if(productCount>0){
                productCount--;
                System.out.println(Thread.currentThread().getName()+"開始消費..."+productCount);
                //
                notifyAll();
            }else{
                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }



    }
    public synchronized void produce(){

            if (productCount < 20) {
                productCount++;
                System.out.println(Thread.currentThread().getName() + "開始生產..." + productCount);
                //只要生產產品就可以叫醒消費者
                notifyAll();
            } else {
                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

}


public class DemoThreadEx {
    public static void main(String[] args) {
        Clerk clerk = new Clerk();
        Consumer consumer = new Consumer(clerk);
        Producer producer = new Producer(clerk);

        consumer.start();
        producer.start();




    }
}
