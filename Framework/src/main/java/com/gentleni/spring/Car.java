package com.gentleni.spring;

/**
 * Created by GentleNi
 * Date 2019/1/30.
 */
public class Car {
    private String brand;
    private String corp;
    private int price;
    private int maxSpeed;

    public Car() {
    }

    public Car(String brand, String corp, int price) {
        this.brand = brand;
        this.corp = corp;
        this.price = price;
    }

    @Override
    public String toString() {
        return "Car{" +
                "brand='" + brand + '\'' +
                ", corp='" + corp + '\'' +
                ", price=" + price +
                ", maxSpeed=" + maxSpeed +
                '}';
    }
}
