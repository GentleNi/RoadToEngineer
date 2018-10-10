package com.gentleni.reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.Modifier;
import java.util.Date;
import java.util.Scanner;

/**
 * Created by GentleNi
 * Date 2018/10/10.
 */
public class ReflectDemo {

    public static void main(String[] args) {
        reflectClass("java.util.Date");
    }

    public static void reflectClass(String className) {
        try {
            Class c = Class.forName(className);
            Class superClasss = c.getSuperclass();

            String modifiers = Modifier.toString(c.getModifiers());
            //output modifier
            if (modifiers.length() > 0) {
                System.out.print(modifiers + " ");
            }
            //output class name
            System.out.print("class "+c.getName());
            //superclass
            System.out.println(" extends " + superClasss.getName() + "{");
            //Constructors
            printConstructors(c);

            System.out.println();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void printConstructors (Class c) {
        Constructor[] declaredConstructors = c.getDeclaredConstructors();
        for (Constructor ct :declaredConstructors) {
            String name = ct.getName();
            String modifier = Modifier.toString(ct.getModifiers());
            System.out.println("    ");
            if (modifier.length() > 0) {
                System.out.println(modifier + " " + name + "(");
            }
            Class[] parameterTypes = ct.getParameterTypes();
            for (int i = 0; i < parameterTypes.length; i++) {
                if (i != parameterTypes.length-1) {
                    System.out.print(parameterTypes[i].getName() + ",");
                }
            }
            System.out.println(")");

        }
    }

}
