package wuhen.spring.beans.autowire;

// TODO: 2020/7/15 车辆信息
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
}
