package Lambda;

import org.junit.Test;

import java.util.Comparator;
import java.util.function.Consumer;

/**
 * Lambda表達式的使用
 * 1.舉例: (o1,o2) -> Integer(o1,o2)
 * 2.格式:
 *      ->    :lambda操作符 或 箭頭操作符
 *      ->左邊 :lambda型參列表(就是介面中抽象方法的型參列表)
 *      ->右邊 :lambda(其實就是重寫的抽象方法的方法體)
 * 3.lambda表達式的使用:
 *      (分成6種情況)
 *      總結
 *      lambda輸入參數的資料型態可以省略(類型推斷),如果只有一個參數,可以省略()
 *      lambd裡面應該用一對{}包住,如果只有一條執行語句,可以省略{}和return關鍵字(省了大括號return一定也不能寫)
 *
 *      介面的特殊要求：函數式介面(該介面只有一個要實現的抽象方法)
 *
 * 4.lambda表達式的本質:
 *      作為介面的實例
 *
 */
public class LambdaTest1 {
    //格式一：無參數,無回傳值
    @Test
    public void test1(){

        Runnable r2 =()-> System.out.println("run 2");

    }
    //格式二：一個參數,無回傳值
    @Test
    public void test2(){
        Consumer<String> con = new Consumer<String>(){
            @Override
            public void accept(String s) {
                System.out.println(s);
            }
        };
        con.accept("謊言和誓言的差別");
        System.out.println("**************");

        Consumer<String> con2 = (String s)-> {
            System.out.println(s);
        };
        con2.accept("一個是聽的人當真了,一個是說的人當真了");
    }
    //格式三：資料型態可以省略，因為可以編譯器推斷得出,稱為類型推斷
    @Test
    public void test3(){
        Consumer<String> con2 = (s)-> {
            System.out.println(s);
        };
        con2.accept("資料型態推斷");
    }
    //格式四：lambda若只有一個參數,小括號可以省略
    @Test
    public void test4(){
        Consumer<String> con2 = s-> {
            System.out.println(s);
        };
        con2.accept("括號省略");
    }
    //格式五：lambda需要兩個以上的參數,多條執行語句,並且有返回值
    @Test
    public void test5(){
        Comparator<Integer> com = (o1, o2)-> {
            System.out.println(o1+","+o2);
            return Integer.compare(o1,o2);
        };
        System.out.println(com.compare(12,6));
    }
    //格式六：當lumbda體只有一句,return和大括號可以省略
    @Test
    public void test6(){
        Comparator<Integer> com2 = (o1,o2)-> Integer.compare(o1,o2);
        System.out.println(com2.compare(12,6));
    }


}
