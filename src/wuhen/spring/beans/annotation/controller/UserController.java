package wuhen.spring.beans.annotation.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import wuhen.spring.beans.annotation.service.UserService;

// TODO: 2020/7/17 通过注解配置bean
@Controller
public class UserController {

    @Autowired
    private UserService userService;

    public void execute(){
        System.out.println("UserController execute...");
        userService.add();
    }

}
