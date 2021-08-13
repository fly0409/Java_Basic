package model;

public class Person {
    private String name;
    public  Integer age;

    public Person() {
    }

    public Person(String name, Integer age) {
        this.name = name;
        this.age = age;
    }
    private Person(String name) {
        this.name = name;
    }

    public void show(){
        System.out.println("我是一個人");
    }

    private String showArea(String area){
        System.out.println("我的地區"+area);
        return area;
    }

    public static void showInfo(){
        System.out.println("一隻小豬");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
