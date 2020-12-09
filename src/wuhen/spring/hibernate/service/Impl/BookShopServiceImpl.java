package wuhen.spring.hibernate.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import wuhen.spring.hibernate.dao.BookShopDao;
import wuhen.spring.hibernate.service.BookShopService;

// TODO: 2020/7/23 购买书本的实例
@Service
public class BookShopServiceImpl implements BookShopService {

    @Autowired
    private BookShopDao bookShopDao;

    /**
     * Spring hibernate 事务的流程
     * 1.在方法开始之前
     * ①.获取Session
     * ②.把Session和当前线程绑定，这样就可以在Dao中使用SessionFactory的getCurrentSession()方法来获取Session了
     * ③.开启事务
     *
     * 2.若方法正常结束，即没有出现异常，则
     * ①.提交事务
     * ②.使和当前线程绑定的Session接除绑定
     * ③.关闭Session
     *
     * 3.若方法出现异常，则：
     * ①.回滚事务
     * ②.使和当前线程绑定的Session接除绑定
     * ③.关闭Session
     */

    //可用注解配合<tx:annotation-driven transaction-manager="transactionManager"/>解决No Session found for current thread报错问题
    //@Transactional
    @Override
    public void purchase(String username, String isbn) {

        int price = bookShopDao.findBookPriceByIsbn(isbn);
        bookShopDao.updateBookStock(isbn);
        bookShopDao.updateUserAccount(username, price);

    }
}
