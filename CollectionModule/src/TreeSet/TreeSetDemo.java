package TreeSet;

import HashSet.User;
import org.junit.Test;

import java.util.Iterator;
import java.util.TreeSet;

public class TreeSetDemo {

    @Test
    public void test1(){
        TreeSet treeSet = new TreeSet();
        treeSet.add(123);
        treeSet.add(456);
        treeSet.add(789);
        treeSet.add(111);

        Iterator iterator = treeSet.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }

    }
    @Test
    public void test2(){
        TreeSet treeSet = new TreeSet();
        treeSet.add(new User(12,"Tom"));
        treeSet.add(new User(13,"Jerry"));
        treeSet.add(new User(15,"Mark"));
        treeSet.add(new User(18,"George"));
        treeSet.add(new User(28,"George"));

        Iterator iterator = treeSet.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}

