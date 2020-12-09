package wuhen.spring.tx;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Arrays;

// TODO: 2020/7/20 主要测试类  7/21声明事务
public class SpringTransactionTest {

    private ApplicationContext applicationContext = null;
    private BookShopDao bookShopDao = null;
    private BookShopService bookShopService = null;
    private Cashier cashier = null;

    {
        applicationContext = new ClassPathXmlApplicationContext("spring-config.xml");
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

    @Test
    public void testBookShopDaoUpdateUserAccount(){
        bookShopDao.updateUserAccount("AA", 200);
    }

    @Test
    public void testBookShopDaoUpdateBookStock(){
        bookShopDao.updateBookStock("1001");
    }

    @Test
    public void testBookShopDaoFindPriceByIsbn(){
        System.out.println(bookShopDao.findBookPriceByIsbn("1001"));
    }

}
