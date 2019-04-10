package com.gentleni.algorithm_problem.jianzhioffer;

/**
 * Created by GentleNi
 * Date 2019/2/11.
 */
public class Demo16_Power {

    public static final double INFINITY = 1.0 / 0.0;

    public double power(double base, int exponent) {
        if (base == 0 && exponent < 0)
            return INFINITY;
        if (exponent > 0)
            return unsignedpower(base,exponent);
        return 1.0 / unsignedpower(base,Math.abs(exponent));
    }

    private double unsignedpower(double base, int exponent) {
        if (exponent == 0)
            return 0;
        if (exponent == 1.0 || base == 1.0)
            return base;
        double power = unsignedpower(base * base,exponent / 2);
        if (exponent % 2 == 1)
            power = power * base;
        return power;
    }

    public static void main(String[] args) {
        Demo16_Power power = new Demo16_Power();
        System.out.println(power.power(2,-1));
        System.out.println(power.power(2,10));
        System.out.println(power.power(2,9));
    }
}
