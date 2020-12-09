package wuhen.spring.beans.first;

// TODO: 2020/7/15  Spring里的HelloWorld
public class HelloWorld {

    private String name;

    public HelloWorld() {
        System.out.println("HelloWorld's constructor...");
    }

    public void setName(String name) {
        System.out.println("setName:" + name);
        this.name = name;
    }
    public void hello(){
        System.out.println("hello:" + name);
    }

}
