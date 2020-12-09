package wuhen.spring.tx_xml.service.impl;

import wuhen.spring.tx_xml.BookShopDao;
import wuhen.spring.tx_xml.service.BookShopService;

// TODO: 2020/7/21 使用xml方式配置事务
public class BookShopServiceImpl implements BookShopService {

    private BookShopDao bookShopDao;

    public void setBookShopDao(BookShopDao bookShopDao) {
        this.bookShopDao = bookShopDao;
    }

    @Override
    public void purchase(String username, String isbn) {

        try {
            Thread.sleep(1000);
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
