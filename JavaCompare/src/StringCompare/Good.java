package StringCompare;

public class Good implements Comparable{
    private String name;
    private Double price;

    public Good(String name, Double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Good{" +
                "name='" + name + '\'' +
                ", price=" + price +
                '}';
    }

    @Override
    public int compareTo(Object o) {
        if (o instanceof Good){
            Good good = (Good)o;
            if(this.price>good.price){
                return 1;
            }else if(this.price < good.price){
                return -1;
            }else{
                //return 0;
                return this.name.compareTo(good.name);
            }
        }else{
            throw new RuntimeException("input class error");
        }
    }
}
