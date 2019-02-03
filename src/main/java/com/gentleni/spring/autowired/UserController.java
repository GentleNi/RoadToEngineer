package com.gentleni.spring.autowired;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

/**
 * Created by GentleNi
 * Date 2019/1/30.
 */
@Controller
public class UserController {

    @Autowired
    private UserService userService;

    public void execute() {
        System.out.println("UserController execute");
        userService.add();
    }
}
