package wuhen.spring.beans.factorybean;

// TODO: 2020/7/16 通过工厂方法配置Bean
public class Car {
    private String brand;
    private double price;

    @Override
    public String toString() {
        return "Car[" +
                "brand='" + brand + '\'' +
                ", price=" + price +
                ']';
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Car() {
        System.out.println("Car's Constructor...");
    }

    public Car(String brand, double price) {
        super();
        this.brand = brand;
        this.price = price;
    }
}
