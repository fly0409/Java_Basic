package Lambda;
import org.junit.Test;

import java.util.Comparator;

/**
 *  初探lambda表達式
 *
 */
public class LambdaExpression {
    @Test
    public void test1(){
        Runnable r1 = new Runnable() {
            @Override
            public void run() {
                System.out.println("run 1");
            }
        };

        r1.run();
        System.out.println("*****************");
        Runnable r2 =()-> System.out.println("run 2");
        r2.run();
    }

    @Test
    public void test2(){
        Comparator<Integer> com1 = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return Integer.compare(o1,o2);
            }
        };
        int compare1 = com1.compare(12,21);
        System.out.println(compare1);

        System.out.println("*****************");
        //一個介面只要實現一個抽象方法
        //lambda表達式寫法
        Comparator<Integer> com2 = (o1,o2)-> Integer.compare(o1,o2);

        int compare2 = com2.compare(120,21);
        System.out.println(compare2);
        System.out.println("*****************");
        //method references 方法參照
        Comparator<Integer> com3 =Integer :: compare;

        int compare3 = com3.compare(120,21);
        System.out.println(compare3);

    }

}
