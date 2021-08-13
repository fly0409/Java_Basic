package model;

import org.junit.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Random;

/**
 * 通過反射來創建運行時class的物件
 *
 */
public class NewInstance {

    @Test
    public void test1() throws InstantiationException, IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        Class<Person> clazz = Person.class;

        /**
         * 創建運行時類的物件
         * new instance方法 會調用 class的 不帶參數的建構子(但沒辦法呼叫private的建構子)
         * 想要創建此物件必須符合兩個原則
         * 1.必須帶有無參數的建構子
         * 2.此建構子的訪問權限要夠(通常設定為public)
         */
        Person obj = clazz.getDeclaredConstructor().newInstance();
        System.out.println(obj.toString());
                
    }

    /**
     * 透過運行時的隨機數
     * 建立動態生成的物件
     */
    @Test
    public void test2(){
        for(int i = 0; i <10;i++){
            int num = new Random().nextInt(3); //0,1,2
            String classpath = "";
            switch (num){
                case 0:
                    classpath = "java.util.Date";
                    break;
                case 1:
                    classpath = "java.lang.Object";
                    break;
                case 2:
                    classpath = "model.Person";
                    break;
                default:
                    break;
            }
            try {
                Object obj = getInstance(classpath);
                System.out.println(obj);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }

    public Object getInstance(String pathname) throws Exception {
        Class clazz = Class.forName(pathname);
        return clazz.getDeclaredConstructor().newInstance();
    }

    public void getSuperGeneric(){
        Class clazz = NewInstance.class;
        Type genericSuperclass = clazz.getGenericSuperclass();
        ParameterizedType paramType = (ParameterizedType)genericSuperclass;
        Type[] actualTypeArguments = paramType.getActualTypeArguments();
        System.out.println(actualTypeArguments[0].getTypeName());
        System.out.println(((Class)actualTypeArguments[0]).getName());

    }
}
