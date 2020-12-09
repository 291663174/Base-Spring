package wuhen.spring.tx_xml;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import wuhen.spring.tx_xml.service.BookShopService;
import wuhen.spring.tx_xml.service.Cashier;

import java.util.Arrays;

// TODO: 2020/7/20 主要测试类  7/21声明事务  使用xml方式配置事务
public class SpringTransactionTest {

    private ApplicationContext applicationContext = null;
    private BookShopDao bookShopDao = null;
    private BookShopService bookShopService = null;
    private Cashier cashier = null;

    {
        applicationContext = new ClassPathXmlApplicationContext("tx_xml.xml");
        bookShopDao = applicationContext.getBean(BookShopDao.class);
        bookShopService = applicationContext.getBean(BookShopService.class);
        cashier = applicationContext.getBean(Cashier.class);
    }

    @Test
    public void testransactionlPropagation(){
        cashier.checkout("AA", Arrays.asList("1001","1002"));
    }

    @Test
    public void testBookShopService(){
        bookShopService.purchase("AA", "1001");
    }

}
