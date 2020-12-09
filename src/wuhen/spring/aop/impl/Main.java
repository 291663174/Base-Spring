package wuhen.spring.aop.impl;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

// TODO: 2020/7/17  测试IOC容器的前置通知是否生效
public class Main {
    public static void main(String[] args) {

        //1.创建Spring的IOC容器
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");

        //2.从IOC容器中获取bean的实例
        ArithmeticCalculator arithmeticCalculator = applicationContext.getBean(ArithmeticCalculator.class);

        //3.使用bean
        int result = arithmeticCalculator.add(3, 6);
        System.out.println("result:" + result);

        result = arithmeticCalculator.div(12, 6);
        System.out.println("result:" + result);
    }

}
