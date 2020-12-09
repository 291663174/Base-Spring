package wuhen.spring.tx;

import java.util.List;

// TODO: 2020/7/21 事务的传播行为接口
public interface Cashier {

    public void checkout(String username, List<String> isbns);

}
