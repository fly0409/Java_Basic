package HashSet;

import org.junit.Test;

import java.util.HashSet;
import java.util.Iterator;

public class HashSetDemo {


    @Test
    public void test1(){
        HashSet hashSet = new HashSet();
        hashSet.add(123);
        hashSet.add(123);
        hashSet.add(456);
        hashSet.add("hi");
        hashSet.add(new User(18,"lin"));
        hashSet.add(new User(18,"lin"));

        Iterator iterator = hashSet.iterator();
        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }
}
