package wuhen.spring.beans.generic.di;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

// TODO: 2020/7/17 泛型依赖注入
public class Main {

    public static void main(String[] args) {

        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("beans-generic-di.xml");
        UserService userService = (UserService) applicationContext.getBean("userService");
        userService.add();

    }

}
