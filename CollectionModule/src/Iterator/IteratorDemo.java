package Iterator;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;


public class IteratorDemo {

    @Test
    public void tes1() {
        Collection coll = new ArrayList();
        coll.add(111);
        coll.add(222);
        coll.add(333);
        //方式1
          Iterator iterator = coll.iterator();
        for (int i = 0; i < coll.size(); i++) {
            System.out.println(iterator.next());
        }
        //方式2
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }
    @Test
    public void test2() {

        Collection coll = new ArrayList();
        coll.add(111);
        coll.add(222);
        coll.add(333);
        coll.add(new String("Tom"));
        Object obj=null;
        Iterator iterator = coll.iterator();
        while (iterator.hasNext()) {

            if ("Tom".equals(obj = iterator.next())) {
                iterator.remove();
            }
            System.out.println(obj);
        }
        System.out.println("********");

        Iterator i2 = coll.iterator();

        while (i2.hasNext()) {
            System.out.println(i2.next());
        }
    }
    @Test
    public  void test4(){
        String[] strs = new String[]{"MM", "MM", "MM"};
        for (int i = 0; i < strs.length; i++) {
            strs[i] ="GG";
        }
        for (int i = 0; i < strs.length; i++) {
            System.out.println(strs[i]);
        } //GG,GG,GG

        for (String str :strs){
            str="QQ";
        }
        for (int i = 0; i < strs.length; i++) {
            System.out.println(strs[i]);
        } //GG,GG,GG

    }



}
