package wuhen.spring.beans.annotation.repository;

import org.springframework.stereotype.Repository;

// TODO: 2020/7/17 通过注解配置bean
@Repository
public class UserJdbcRepository implements UserRepository{

    @Override
    public void save() {
        System.out.println("UserJdbcRepository save...");
    }
}
