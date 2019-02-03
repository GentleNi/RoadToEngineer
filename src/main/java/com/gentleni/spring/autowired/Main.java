package com.gentleni.spring.autowired;

import com.gentleni.spring.HelloWord;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by GentleNi
 * Date 2019/1/30.
 */
public class Main {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("beans-autowired.xml");
        UserController userController = (UserController) context.getBean("userController");
        userController.execute();
    }
}
