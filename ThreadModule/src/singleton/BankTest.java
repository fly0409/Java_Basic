package singleton;


public class BankTest {
    public static void main(String[] args) {
        ThreadTest t1 = new ThreadTest();

        Thread th1 = new Thread(t1);
        Thread th2 = new Thread(t1);

        th1.start();
        th2.start();



        //Thread t1 = new Thread(ThreadTest);
    }

}

/**
 * singleton
 * 會有執行續安全問題  why? 假如兩個執行續同時要執行getInstance,同時判斷為null的時候，就會個建立一個instance
 * 將lazy singleton 改為 thread safe
 *
 */
class Bank{

    private static Bank instance = null;

    private Bank(){
    }

    //解決線程安全問題 加入synchronized
    public static Bank getInstance(){
        //方式1 =>此方式有效率問題 why?如果instance已經不為null了，但每個線程還要排隊來看是否為null
        //synchronized (Bank.class){
        //    if (instance ==null){
        //        instance = new Bank();
        //   }
        //    return instance;
        // }
        //方式2 =>效率較好
        if (instance ==null) {
            synchronized (Bank.class) {
                if (instance == null) {
                    instance = new Bank();
                }
            }
        }
        return instance;
    }
}

class ThreadTest implements Runnable{

    @Override
    public void run() {
        Bank ins = Bank.getInstance();
        System.out.println(ins.toString());
    }
}