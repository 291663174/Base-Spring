package wuhen.spring.tx;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

// TODO: 2020/7/20 购买接口实例  7/21事务的传播行为
@Service("bookShopService")
public class BookShopServiceImpl implements BookShopService {

    @Autowired
    private BookShopDao bookShopDao;

    //添加事务注解,使在余额不足情况下购买不成功，不扣库存数量，也不扣余额
    //1.使用propagation指定事务的传播行为，即当前的事务方法被另外一个事务方法调用时
    //如何使用事务，默认取值为REQUIRED，即使用调用方法的事务
    //使用REQUIRES_NEW可实现批量买书且余额不足时，先按顺序购买当前余额足够支付的书
    //REQUIRES_NEW:事务自己的事务，调用的事务方法的事务被挂起
    //2.使用isolation指定事务的隔离级别，最常用的取值为READ_COMMITTED
    //3.默认情况下Spring的声明式事务对所有的运行时异常进行回滚，也可以通过对应的属性进行设置
    //4.使用readOnly指定事务是否为只读。表示这个事务只读取数据但不更新数据，这样可以帮助数据库引擎优化事务。
    // 若真的是一个只读取数据库值的方法，应设置readOnly=true
    //5.使用timeout指定强制回滚之前事务可以占用的时间xxx毫秒
    @Transactional(propagation = Propagation.REQUIRES_NEW
            , isolation = Isolation.READ_COMMITTED
            , readOnly = false
            , timeout = 3)

    @Override
    public void purchase(String username, String isbn) {

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        //1.获取书的单价
        int price = bookShopDao.findBookPriceByIsbn(isbn);

        //2.更新书的库存
        bookShopDao.updateBookStock(isbn);

        //3.更新用户余额
        bookShopDao.updateUserAccount(username, price);

    }

}
