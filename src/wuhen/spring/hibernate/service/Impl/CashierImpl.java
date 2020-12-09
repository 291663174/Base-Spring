package wuhen.spring.hibernate.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import wuhen.spring.hibernate.service.BookShopService;
import wuhen.spring.hibernate.service.Cashier;

import java.util.List;

// TODO: 2020/7/23 多本书算账
@Service
public class CashierImpl implements Cashier {

    @Autowired
    private BookShopService bookShopService;

    @Override
    public void checkout(String username, List<String> isbns) {
        for(String isbn:isbns){
            bookShopService.purchase(username, isbn);
        }
    }
}
