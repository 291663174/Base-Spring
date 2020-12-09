package wuhen.spring.beans.first;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

// TODO: 2020/7/15  Spring的IOC容器创建
public class Main {

    public static void main(String[] args) {

        /* 下面2步可以交给Spring来完成
            //创建HelloWorld的一个对象
            HelloWorld helloWorld = new HelloWorld();
            //为name属性赋值
            helloWorld.setName("wuhen");
        */

        //1.创建Spring的IOC容器对象
        //ApplicationContext是Spring里的IOC容器，实际上是一个接口
        //ClassPathXmlApplicationContext 是 ApplicationContext 的实现类
        //ClassPathXmlApplicationContext表示配置文件在类路径下，传入配置文件名字
        //创建容器时会调用构造器对配置文件的Bean进行初始化，同时会调用setName方法进行赋值
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-config.xml");

        //2.从IOC容器中获取Bean实例
        //利用id定位到IOC容器中的bean
        HelloWorld helloWorld = (HelloWorld) applicationContext.getBean("helloWorld2");
        //利用类型返回IOC容器中的Bean，但要求IOC容器中必须只能有一个该类型的Bean
        System.out.println(helloWorld);

        //3.调用hello方法
        //helloWorld.hello();

        Car car = (Car) applicationContext.getBean("car");
        System.out.println(car);

        car = (Car) applicationContext.getBean("car2");
        System.out.println(car);
    }

}
