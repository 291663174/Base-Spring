package wuhen.spring.struts2.beans;

// TODO: 2020/7/24 测试Bean
public class Person {

    private String username;

    public void setUsername(String username) {
        this.username = username;
    }

    public void hello(){
        System.out.println("My name is " + username);
    }

}
