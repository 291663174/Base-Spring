package wuhen.spring.beans.annotation.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import wuhen.spring.beans.annotation.TestObject;

// TODO: 2020/7/17 通过注解配置bean
@Repository
public class UserRepositoryImpl implements UserRepository {

    //    @Autowired(required = false)  没有bean也可以运行
    @Autowired
    private TestObject testObject;

    @Override
    public void save() {
        System.out.println("UserRepository Save...");
        System.out.println(testObject);
    }

}
