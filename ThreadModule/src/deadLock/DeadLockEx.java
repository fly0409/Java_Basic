package deadLock;
/**
 *   DeadLock 不同的執行續分別占用對方的同步資源不放
 *   都在等待對方放棄自己需要的同步資源
 *   不會有異常，不會有提示，只是線程阻塞
 *   解法：
 *   >專門的演算法與原則
 *   >減少同步資源定義
 *
 */


public class DeadLockEx {

    public static void main(String[] args) {
        StringBuffer s1 = new StringBuffer();
        StringBuffer s2 = new StringBuffer();

        //建立一個匿名thread 物件，
        //第一個執行續，需要用到s1 的鎖後，緊接著用S2的鎖
        //第二個執行續，需要先用s2 的鎖後，緊接著用s1的鎖
        //如果說在執行1裡面先用s1在用s2個過程中，加入sleep(非必要，只是大幅提高機率)，
        //會造成執1 握著s1 && 執2 握著s2 的死鎖形況
        new Thread(){
            @Override
            public void run() {
                synchronized (s1){
                    s1.append('a');
                    s2.append(1);
//                    try {
//                        Thread.sleep(100);
//                    } catch (InterruptedException e) {  e.printStackTrace();}
                    synchronized (s2){
                        s1.append('b');
                        s2.append(2);
                    }

                }
                System.out.println(s1);
                System.out.println(s2);
            }
        }.start();
        
        new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (s2){
                    s1.append('c');
                    s2.append(3);
//                    try {
//                        Thread.sleep(100);
//                    } catch (InterruptedException e) {  e.printStackTrace();}
                    synchronized (s1){
                        s1.append('d');
                        s2.append(4);
                    }

                }
            System.out.println(s1);
            System.out.println(s2);
            }
        }).start();
        
        
        
    }
    
            
    

}
