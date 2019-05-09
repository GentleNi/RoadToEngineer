package com.gentleni.spring.factory;

import com.gentleni.spring.Car;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by GentleNi
 * Date 2019/1/30.
 */
public class Main {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("beans-factory.xml");
        //2.从IOC容器中获取Bean对象
        Car car = (Car) context.getBean("car");
        System.out.println(car);
    }
}
