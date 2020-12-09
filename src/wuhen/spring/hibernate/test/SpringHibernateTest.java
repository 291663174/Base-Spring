package wuhen.spring.hibernate.test;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import wuhen.spring.hibernate.service.BookShopService;
import wuhen.spring.hibernate.service.Cashier;

import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.Arrays;

// TODO: 2020/7/23  Spring 和 hibernate 的整合  数据库交互的测试代码
public class SpringHibernateTest {

    private ApplicationContext applicationContext = null;
    private BookShopService bookShopService = null;
    private Cashier cashier = null;

    {
        applicationContext = new ClassPathXmlApplicationContext("spring-config.xml");
        bookShopService = applicationContext.getBean(BookShopService.class);
        cashier = applicationContext.getBean(Cashier.class);
    }

    //测试购买2本书后账户余额和库存的变化
    @Test
    public void testCashier(){
        cashier.checkout("aa", Arrays.asList("1001","1002"));
    }

    //测试购买一本书后的变化
    @Test
    public void testBoookShopService(){
        bookShopService.purchase("aa", "1001");
    }

    //通过Spring和hibernate整合连接数据库进行测试，连接成功则生成空表
    @Test
    public void testDataSource() throws SQLException {
        DataSource dataSource = applicationContext.getBean(DataSource.class);
        System.out.println(dataSource.getConnection());
    }
}
