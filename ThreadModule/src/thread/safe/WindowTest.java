package thread.safe;

/**
 * 例子 創立3個窗口 總票數100 實現runnable
 *  在執行期間 出現了重複的票或是不合理的票號
 *  問題原因：當某個現成再進行操作的時候，當還沒完成一次操作時，另一個線程進來了
 *  解法：當一個線程正在操作的時候，其他線程不能參與，即使線程出現阻塞也不能改變
 *
 *  在java中，通過同步機制來解決
 *  法一 同步code：
 *    synchronized(同步監視器){
 *        //需要被同步的程式碼=>操作共享數據(多個線程共同操作的變數)的程式碼
 *    }
 *     同步監視器是甚麼?俗稱鎖
 *     任何一個類的物件都可以當成鎖
 *     要求=>多個線程必須要用同一把鎖(物件要是同一個)
 *     侷限=>操作同步程式碼時，效率較低
 *
 *     補充 可以用this(實作runnable)或是class(繼承Thread)來當同步監視器
 *  法二 同步方法
 *      如果需要操作共享數據的程式碼作用在同一個方法中，可以直接聲明同步方法
 *      實現runnable=> private synchronized void method ...(同步監視器為this 該物件)
 *      繼承thread=> static synchronized void method...(static 沒有 this,此時同步監視器為 .class物件 )
 *      1.同步方法的使用仍然有用同步監視器，不過是默認的
 *
 */
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

    int count = 50;
    Object obj = new Object();
    @Override
    public void run() {

        while(true){
            synchronized(obj){
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

            }
        }
    }
}
