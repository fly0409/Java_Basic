package threadWithExtend.safe;

/** 使用同步 來解決繼承問題
 *  new 一個 static 的 obj
 *  如果不要新建物件?
 *
 *
 *
 */
public class WindowTestWithThread {

    public static void main(String[] args) {
        //Object obj = new Object();
        WindowEx w1 = new WindowEx();
        WindowEx w2 = new WindowEx();
        WindowEx w3 = new WindowEx();
        w1.start();
        w2.start();
        w3.start();

    }

}

class WindowEx extends Thread{
    
    private static Integer ticket = 100;
    private static Object obj = new Object();
    @Override
    public void run() {
        //WindowEx 這個class 只會加載一次
        synchronized (WindowEx.class){
            while (true){

                if (ticket >0){
                    try {
                        sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(getName()+"："+ticket);

                    ticket--;
                }else{
                    break;
                }
            }
        }

    }
}
