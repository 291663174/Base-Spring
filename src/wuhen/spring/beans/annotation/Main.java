package wuhen.spring.beans.annotation;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import wuhen.spring.beans.annotation.controller.UserController;
import wuhen.spring.beans.annotation.repository.UserRepository;
import wuhen.spring.beans.annotation.service.UserService;

// TODO: 2020/7/17 通过注解配置bean
public class Main {
    public static void main(String[] args) {

        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("beans-annotation.xml");
//        TestObject testObject = (TestObject) applicationContext.getBean("testObject");
//        System.out.println(testObject);
//
        UserController userController = (UserController) applicationContext.getBean("userController");
        System.out.println(userController);
        userController.execute();
//
//        UserService userService = (UserService) applicationContext.getBean("userService");
//        System.out.println(userService);

//        UserRepository userRepository = (UserRepository) applicationContext.getBean("userRepository");
//        System.out.println(userRepository);
    }
}
