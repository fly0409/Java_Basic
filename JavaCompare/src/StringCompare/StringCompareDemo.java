package StringCompare;

import org.junit.Test;

import java.util.Arrays;

public class StringCompareDemo {

    /**
     * Compareble介面使用舉例=>稱為自然排序
     * 1.String 包裝類都時做了Comparable介面，重寫comparaTo(),
     * 2.包裝類重寫ComparaTo()。進行從大到小的排列
     * 3.重寫的規則：
     *  如果當前物件大於this大於傳入物件obj，傳回正整數
     *  如果當前物件大於this等於傳入物件obj，傳回0
     *  如果當前物件大於this小於傳入物件obj，傳回負整數
     * 4.對於自定義類中，如果需要排序，要實作Comparable()
     *   在comparaTo()中說明如何排序
     */
    @Test
    public void test1(){
        String[] arr = new String[]{"AA","CC","YY","KK","MM"};
        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));
        //String有override compareTo
    }

    @Test
    public void test2(){
        Good[] goods = {new Good("mm",11.0),new Good("aa",12.0),new Good("bb",7.0),new Good("cc",12.0)};
        Arrays.sort(goods);
        System.out.println(Arrays.toString(goods));
    }
}
