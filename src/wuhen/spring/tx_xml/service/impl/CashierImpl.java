package wuhen.spring.tx_xml.service.impl;

import wuhen.spring.tx_xml.service.BookShopService;
import wuhen.spring.tx_xml.service.Cashier;

import java.util.List;

// TODO: 2020/7/21 事务的传播行为实例  使用xml方式配置事务
public class CashierImpl implements Cashier {

    private BookShopService bookShopService;

    public void setBookShopService(BookShopService bookShopService) {
        this.bookShopService = bookShopService;
    }

    @Override
    public void checkout(String username, List<String> isbns) {

        for (String isbn:isbns){
            bookShopService.purchase(username, isbn);
        }

    }
}
