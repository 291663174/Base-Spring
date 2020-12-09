package wuhen.spring.beans.annotation.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import wuhen.spring.beans.annotation.repository.UserRepository;

// TODO: 2020/7/17 通过注解配置bean
@Service
public class UserService {

    // @Autowired
    // @Qualifier("userRepositoryImpl")
    private UserRepository userRepository;

    //bean名字和属性名字一样即可装配
    @Autowired
    public void setUserRepository(@Qualifier("userRepositoryImpl") UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void add() {
        System.out.println("UserService add...");
        userRepository.save();
    }

}
