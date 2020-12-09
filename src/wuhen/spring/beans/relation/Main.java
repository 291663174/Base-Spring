package wuhen.spring.beans.relation;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import wuhen.spring.beans.autowire.Address;
import wuhen.spring.beans.autowire.Person;

// TODO: 2020/7/15 Bean的继承 
public class Main {

    public static void main(String[] args) {

        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("beans-relation.xml");

        //抽象bean不能被IOC容器实例化
        //Address address = (Address) applicationContext.getBean("address");
        //System.out.println(address);

        Address address = (Address) applicationContext.getBean("address2");
        System.out.println(address);

        address = (Address) applicationContext.getBean("address3");
        System.out.println(address);

        Person person = (Person) applicationContext.getBean("person");
        System.out.println(person);
    }

}
