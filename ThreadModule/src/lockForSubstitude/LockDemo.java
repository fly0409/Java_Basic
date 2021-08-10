package lockForSubstitude;

import java.util.concurrent.locks.ReentrantLock;

/**
 *  解決線程安全方式 lock 鎖 JDK5.0新增
 *  比較synchronize & lock
 *  1.都可以解決線程安全問題
 *  2.sync機制在執行完相對應的同步區塊後，自動釋放同步監視器
 *    lock 需要手動啟動同步，結束同步也需要手動實現
 *  3.(不確定)使用lock鎖，JVM將花費較少時間來調度線程，性能較好，並有較高擴展性
 *
 */

public class LockDemo {
    public static void main(String[] args) {

            WindowsLock w1= new WindowsLock();

            Thread t1 = new Thread(w1);
            Thread t2 = new Thread(w1);
            Thread t3 = new Thread(w1);

            t1.start();
            t2.start();
            t3.start();


    }
}


class WindowsLock implements Runnable{

    int count = 100;
    //1.建立Reentrantlock 物件(true的話就是幫各個線程照順序排好依序去 取的同步資源)
    private ReentrantLock lock = new ReentrantLock(true);

    @Override
    public void run() {

        while(true){
                //2. 將需要同步的資源放在try區塊
                //   呼叫lock 方法，將其他線程鎖在外面
            try {
                lock.lock();
                if(count >0){
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName() +"："+ count--);
                    //count--;
                }else{
                    break;
                }
            }finally {
                //3.呼叫unlock方法，把鎖解開，等待其他線程的進入
                lock.unlock();
            }

        }
    }
}