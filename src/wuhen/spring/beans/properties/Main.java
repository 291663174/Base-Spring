package wuhen.spring.beans.properties;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import wuhen.spring.beans.autowire.Car;

import javax.sql.DataSource;
import javax.xml.crypto.Data;
import java.sql.SQLException;

// TODO: 2020/7/15  使用外部属性文件
public class Main {

    public static void main(String[] args) throws SQLException {

        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("beans-properties.xml");

        DataSource dataSource = (DataSource) applicationContext.getBean("dataSource");
        System.out.println(dataSource.getConnection());
    }

}
