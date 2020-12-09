package wuhen.spring.hibernate.service;

import org.springframework.transaction.annotation.Transactional;

import java.util.List;

// TODO: 2020/7/21 事务的传播行为接口  使用xml方式配置事务
public interface Cashier {

    public void checkout(String username, List<String> isbns);

}
