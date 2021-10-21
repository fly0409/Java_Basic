package Generic;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

public class Generic {
    /**
     * 泛型 =>類似標籤的概念
     *
     * 集合的container在設計以及剛建立的狀態下
     * 無法確定該容器實際上裝的是甚麼類型的物件
     * 1.5以前把元素類型設計成Object,1.5以後則改用泛型解決
     * 把元素的類型設計成一個參數，叫做泛型
     *    比如collection裡面的 add(E e)，此時放進去的參數不是Object 而是 E
     *
     * 在實例化集合類時 可以指名具體的泛行類型
     *
     */



   //沒泛型
    @Test
    public void test1(){
        ArrayList arrlist = new ArrayList();
        arrlist.add(97);
        arrlist.add(82);
        arrlist.add(78);
        //問題一 類型不安全
        arrlist.add("tom");

        for (Object obj:arrlist) {
            //問題二 強轉時會出現類型轉換異常
            int score = (Integer)obj;
            System.out.println(score);
        }
    }
    //再添加時檢查=>使用泛型
    @Test
    public void test2(){
        //泛型不能用基本數字類型
        ArrayList<Integer> arrlist = new ArrayList<Integer>();
        arrlist.add(97);
        arrlist.add(82);
        arrlist.add(78);
        //問題一 類型不安全
        //arrlist.add("tom");

        for (Integer obj:arrlist) {
            //問題二 強轉時會出現類型轉換異常
            int score = obj;
            System.out.println(score);
        }

        Iterator<Integer> iterator = arrlist.iterator();
        while (iterator.hasNext()){
            //public interface Iterator<E> {
            //E next();
            //}
            System.out.println(iterator.next());
        }


    }

}
