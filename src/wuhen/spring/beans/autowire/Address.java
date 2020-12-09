package wuhen.spring.beans.autowire;

// TODO: 2020/7/15 地址
public class Address {

    private String city;
    private String street;

    //重写toString()方法，方便进行测试
    @Override
    public String toString() {
        return "Address[" +
                "city='" + city + '\'' +
                ", street='" + street + '\'' +
                ']';
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }
}
