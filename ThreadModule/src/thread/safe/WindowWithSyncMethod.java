package thread.safe;

public class WindowWithSyncMethod {
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


class Windows3 implements Runnable{

    int count = 50;
    //如果在run方法中 直接加入synchroized ,會有邏輯問題 就只有一個執行續可以跑while迴圈
    @Override
    public void run() {
        while(true){

                show();
            }
        }

    // 將需要同步的區域額外用一個synchroized 包住， 此時的同步監視器為this
    private synchronized void show(){
        if(count >0){
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() +"："+ count--);
            //count--;
        }
    }

}