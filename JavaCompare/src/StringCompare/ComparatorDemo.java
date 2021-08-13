package StringCompare;

import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;

public class ComparatorDemo {
    /**
     * 1.背景：
     *  當元素的類型沒有實線comparable又不方便修改程式碼
     *  或只實現了Comparable的排序規則不適合當前的操作
     * 2.重寫compare(obj1,obj2)方法，比較兩個大小
     *  正數 o1>o2
     */


    @Test
    public void test3(){
        //String 排序預計從小到大，但我們想要從大到小
        String[] arr= new String[]{"AA","CC","KK"};
        Arrays.sort(arr, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return -o1.compareTo(o2);
            }
        });
        System.out.println(Arrays.toString(arr));


    }
}
