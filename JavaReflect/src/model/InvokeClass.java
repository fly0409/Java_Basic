package model;

import org.junit.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class InvokeClass {

    @Test
    public void testField() throws Exception {
        Class<Person> clazz = Person.class;

        //創建運行時的物件
        Person p = clazz.getConstructor().newInstance();

        //獲取指定的屬性
        //Field name = clazz.getField("name");//看不到private喔
        Field name = clazz.getDeclaredField("name");

        //針對private屬性要先設定取得權限
        name.setAccessible(true);
        //設置當前屬性的值
        //set(參數1 哪個物件的屬性，其屬性的值)
        name.set(p,"littlePig");
        //獲取當前屬性值
        String str =(String) name.get(p);
        System.out.println(str);
     }
    @Test
    public void testMethod() throws Exception {
        Class<Person> clazz = Person.class;
        //創建運行時的物件
        Person p = clazz.getConstructor().newInstance();
        //參數1 方法的名稱 ,參數2 指名方法需要參數
        //invoke的return
        Method showArea = clazz.getDeclaredMethod("showArea",String.class);
        showArea.setAccessible(true);
        Object returns = showArea.invoke(p, "嗚嗚");
        System.out.println(returns);
        //靜態
        System.out.println("****static****");
        Method showInfo = clazz.getDeclaredMethod("showInfo");
        showInfo.setAccessible(true);
        //不用指名物件
        //showInfo.invoke(Person.class);
        Object return2 = showInfo.invoke(null);
        System.out.println(return2);

    }

    @Test
    public void testConstructor() throws Exception {
        Class<Person> clazz = Person.class;
        Constructor declaredConstructor = clazz.getDeclaredConstructor();
        declaredConstructor.setAccessible(true);
        //創建物件
        Object p = declaredConstructor.newInstance();
        System.out.println(p.toString());
    }
}
