package wuhen.spring.beans.autowire;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

// TODO: 2020/7/15 自动装配Bean
public class Main {
    public static void main(String[] args) {

        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("beans-autowire.xml");
        Person person = (Person) applicationContext.getBean("person");
        System.out.println(person);

    }
}
