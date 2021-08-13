package proxyDemo;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 *動態代理要解決的問題
 * 問題1 如何根據加載到記憶的的被代理class,動態的創見一個代理class和物件
 * 問題2 當通過代理物件invoke方法的時候,如何動態的去調用被代理類的方法
 *
 */
class ProxyFactoryDemo{
    //根據傳進得來的物件 生成代理物件
    public static Object getProxyInstance(Object obj){
        MyInvocationHandler handler = new MyInvocationHandler();
        handler.bindObject(obj);
        Object proxyObj=Proxy.newProxyInstance(obj.getClass().getClassLoader(), obj.getClass().getInterfaces(), handler);
        return proxyObj;
    }
}
class MyInvocationHandler implements InvocationHandler{
    private Object object;

    public void bindObject(Object object){
        this.object=object;
    }
    //當通過代理類的物件 調用 xx 方法時，會自動調用此invoke方法
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        return method.invoke(object,args);
    }
}
public class DynamicProxyDemo {
    public static void main(String[] args) {
        SuperMan sman = new SuperMan();
        Human man = (Human) ProxyFactoryDemo.getProxyInstance(sman);
        man.eat("peko");
        man.getMind();

        Uniqlo uniqlo = new Uniqlo();
        ClothFactory proxyInstance = (ClothFactory)ProxyFactoryDemo.getProxyInstance(uniqlo);
        proxyInstance.produce();

    }
}
interface Human{
    void getMind();
    String eat(String food);
}

class SuperMan implements Human{

    @Override
    public void getMind() {
        System.out.println("I belief I can fly");
    }

    @Override
    public String eat(String food) {
        System.out.println("I eat "+food);
        return food;
    }
}






