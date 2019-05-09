package com.gentleni.spring.factory;

import com.gentleni.spring.Car;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.cglib.proxy.Factory;

/**
 * Created by GentleNi
 * Date 2019/1/30.
 */
public class CarFactoryBean implements FactoryBean<Car> {

    private String brand;

    public void setBrand(String brand) {
        this.brand = brand;
    }

    @Override
    public Car getObject() throws Exception {
        return new Car(brand,"shanghai",300000);
    }

    @Override
    public Class<?> getObjectType() {
        return Car.class;
    }

    @Override
    public boolean isSingleton() {
        return true;
    }
}
