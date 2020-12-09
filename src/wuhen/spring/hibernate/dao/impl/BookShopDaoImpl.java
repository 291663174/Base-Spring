package wuhen.spring.hibernate.dao.impl;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import wuhen.spring.hibernate.dao.BookShopDao;
import wuhen.spring.hibernate.exceptions.BookStockException;
import wuhen.spring.hibernate.exceptions.UserAccountException;

// TODO: 2020/7/23  数据库交互实例
@Repository
public class BookShopDaoImpl implements BookShopDao {

    //SessionFactory是线程安全的,即便没有Spring在hibernate里面也一样能用
    @Autowired
    private SessionFactory sessionFactory;

    //不推荐使用HibernateTemplate和 extends HibernateDaoSupport
    //因为这样会导致Dao和Spring的API进行耦合，可移植性变差
    //private HibernateTemplate hibernateTemplate;

    //获取和当前线程绑定的Session
    private Session getSession(){
        return (Session) sessionFactory.getCurrentSession();
    }

    //按图书编号查询图书价钱
    @Override
    public int findBookPriceByIsbn(String isbn) {
        String hql = "SELECT b.price FROM Book b WHERE b.isbn = ?";
        Query query = (Query) getSession().createQuery(hql).setString(0,isbn);
        return (Integer)query.uniqueResult();
    }

    //更新图书的库存
    @Override
    public void updateBookStock(String isbn) {
        //验证书的库存是否充足。
        String hql2 = "SELECT b.stock FROM Book b WHERE b.isbn = ?";
        int stock = (int) getSession().createQuery(hql2).setString(0,isbn).uniqueResult();
        if (stock == 0){
            throw new BookStockException("库存不足");
        }

        String hql = "UPDATE Book b SET b.stock = b.stock - 1 WHERE b.isbn = ?";
        getSession().createQuery(hql).setString(0,isbn).executeUpdate();
    }

    //更新用户账户余额
    @Override
    public void updateUserAccount(String username, int price) {
        //验证余额是否足够
        String hql2 = "SELECT a.balance FROM Account a WHERE a.username = ?";
        int balance = (int) getSession().createQuery(hql2).setString(0,username).uniqueResult();
        if (balance < price){
            //运行时异常检查          AccountException是检查时异常
            throw new UserAccountException("余额不足！");
        }

        String hql = "UPDATE Account a SET a.balance = a.balance - ? WHERE a.username = ?";
        getSession().createQuery(hql).setInteger(0, price).setString(1,username).executeUpdate();
    }
}
