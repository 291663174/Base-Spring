package wuhen.spring.beans.scope;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import wuhen.spring.beans.autowire.Address;
import wuhen.spring.beans.autowire.Car;
import wuhen.spring.beans.autowire.Person;

// TODO: 2020/7/15  bean的作用域
public class Main {

    public static void main(String[] args) {

        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("beans-scope.xml");

        Car car = (Car) applicationContext.getBean("car");
        Car car2 = (Car) applicationContext.getBean("car");

        System.out.println(car == car2);
    }

}
