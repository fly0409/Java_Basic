package model;

import org.junit.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ReflectTest {

    //反射之前對於物件的操作
    //在person class外部，無法得知person的內部私有結構
    @Test
    public void test1(){
        Person p1 = new Person("tom",18);
        p1.age = 10;
        System.out.println(p1);
    }
    //反射之後對於物件的操作
    @Test
    public void test2() throws Exception{
        Class<Person> clazz = Person.class;
        //通過反射來創建person物件
        Constructor<Person> cons = clazz.getConstructor(String.class, Integer.class);
        Person obj = cons.newInstance("tom", 18);
        System.out.println(obj.toString());
        //通過反射,調用指定物件的屬性,方法
        Field age = clazz.getDeclaredField("age");
        age.set(obj,10);
        System.out.println(obj.toString());

        //調用方法
        Method show = clazz.getDeclaredMethod("show");
        show.invoke(obj);

        //通過反射調用person class的私有結構
        //調用私有屬性
        Constructor<Person> cons1 = clazz.getDeclaredConstructor(String.class);
        cons1.setAccessible(true);
        Person p2 = cons1.newInstance("Jerry");
        System.out.println(p2);

        Field name = clazz.getDeclaredField("name");
        name.setAccessible(true);
        name.set(p2,"Mouse");

        Method showArea = clazz.getDeclaredMethod("showArea",String.class);
        showArea.setAccessible(true);
        showArea.invoke(p2,"山");

        /**
         * 疑問?
         * 在開發中要用原本的方式 還是反射的方式來造物件?
         *  建議還是用new的方式
         *  甚麼時候會使用反射的方式: 反射的特徵 動態性
         * 反射與物件導向的封裝是否衝突?
         *  封裝代表的是一種建議使用方式，public 幫你建立好該有的邏輯，沒必要不要用private
         *
         */

    }
    //獲取class實例的方式

    @Test
    public void test3() throws Exception{
        //方式一 調用運行時class的屬性 .class
        Class<Person> clazz1 = Person.class;

        //方式二 通過運行是class的物件
        Person p3 = new Person();
        Class clazz2 = p3.getClass();

        //方式三 通過class的靜態方法 forName(class path)
        Class clazz3 = Class.forName("model.Person");

        //方式四 透過classloader
        ClassLoader classloader = ReflectTest.class.getClassLoader();
        Class clazz4 = classloader.loadClass("model.Person");



        System.out.println(clazz1);
        System.out.println(clazz2);
        System.out.println(clazz3);
        System.out.println(clazz4);

        System.out.println(clazz1==clazz2);
        System.out.println(clazz1==clazz3);
        System.out.println(clazz1==clazz4);

    }

}
