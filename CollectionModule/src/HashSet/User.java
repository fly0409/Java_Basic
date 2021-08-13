package HashSet;

import java.util.Objects;

public class User implements Comparable{

    private Integer age;
    private  String name;

    public User() {
    }

    public User(Integer age, String name) {
        this.age = age;
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "User{" +
                "age=" + age +
                ", name='" + name + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(age, user.age) && Objects.equals(name, user.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(age, name);
    }

    @Override
    public int compareTo(Object o) {
        if (o instanceof User){
            User user = (User) o ;
//            return this.name.compareTo(user.name);
            int compare = this.name.compareTo(user.getName());
            if(compare!=0){
                return compare;
            }else{
                return Integer.compare(this.age,user.getAge());
            }
        }else{
            throw new RuntimeException("input object error");
        }
    }
}

