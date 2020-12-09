package wuhen.spring.beans.spel;

// TODO: 2020/7/16 车辆信息 使用SpEL引用类的静态属性
public class Car {

    private String brand;
    private double price;
    //轮胎的周长
    private double tyrePerimete;

    @Override
    public String toString() {
        return "Car[" +
                "brand='" + brand + '\'' +
                ", price=" + price +
                ", tyrePerimete=" + tyrePerimete +
                ']';
    }

    public double getTyrePerimete() {
        return tyrePerimete;
    }

    public void setTyrePerimete(double tyrePerimete) {
        this.tyrePerimete = tyrePerimete;
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
