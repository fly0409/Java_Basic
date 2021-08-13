package proxyDemo;


interface ClothFactory{
    void produce();
}

class Uniqlo implements ClothFactory{

    @Override
    public void produce() {
        System.out.println("produce uniqlo clothes");
    }
}

class ProxyFactory implements  ClothFactory{

    private ClothFactory factory;
    public ProxyFactory(ClothFactory factory){
        this.factory=factory;
    }

    @Override
    public void produce() {
        System.out.println("前置準備");
        factory.produce();
        System.out.println("後續處理");
    }
}


public class StaticProxyTest {
    public static void main(String[] args) {
        ClothFactory factory = new Uniqlo();
        ClothFactory proxyFactory = new ProxyFactory(factory);

        proxyFactory.produce();


    }

}
