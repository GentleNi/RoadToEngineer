package com.gentleni.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by GentleNi
 * Date 2019/1/30.
 */
public class TestHelloWord {
    public static void main(String[] args) {
        //1.创建Spring的IOC容器对象
        //IOC容器
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        //2.从IOC容器中获取Bean对象
        HelloWord helloWord = (HelloWord) context.getBean("helloWord");
        //3。调用hello方法
        helloWord.hello();

        Car car = (Car) context.getBean("car");
        System.out.println(car);
    }
}
