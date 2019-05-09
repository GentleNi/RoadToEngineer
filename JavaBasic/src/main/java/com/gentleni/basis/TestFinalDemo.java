package com.gentleni.basis;

import sun.plugin2.gluegen.runtime.CPU;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;

/**
 * Created by GentleNi
 * Date 2018/11/3.
 */
public class TestFinalDemo {

    private final Map<String,Person> persons ;


    public TestFinalDemo(Map<String, Person> persons) {
        this.persons = persons;
    }

    public Map<String, Person> getPersons() {
        return persons;
    }

    private static Map<String,Person> shallowCopy(Map<String,Person> source) {
        Map<String,Person> copy = new HashMap<>();
        copy.putAll(source);
        return copy;
    }

    private static Map<String,Person> deepCopy(Map<String,Person> source) {
        Map<String,Person> copy = new HashMap<>();
        for (Map.Entry<String,Person> entry : source.entrySet()) {
            Person p = new Person(entry.getValue().getName(),entry.getValue().getAge());
            copy.put(entry.getKey(),p);
        }
        return copy;
    }

    public static void main(String[] args) {
        Map<String,Person> persons = new HashMap<>();
        Person p = new Person("gentleni",22);
        String key = "gentleni";
        persons.put(key,p);
        TestFinalDemo demo = new TestFinalDemo(persons);
        System.out.println(demo.getPersons().get("gentleni"));
        //modify person in set
        p.setName("nijintao");
        System.out.println(demo.getPersons().get("gentleni"));

        //测试克隆1
        Map<String, Person> shallowCopy = shallowCopy(persons);
        System.out.println(shallowCopy.get("gentleni"));


        //测试克隆2
        Map<String,Person> deepCopy = deepCopy(persons);
        System.out.println(deepCopy.get("gentleni"));


        //测试对象是否相等
        System.out.println("persons == shallowCopy " + (persons == shallowCopy));
        System.out.println("persons == deepCopy " + (persons == deepCopy));

        //测试person

    }
}

class Person {
    String name;
    int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}