package com.gentleni.java8;

/**
 * Created by GentleNi
 * Date 2019/3/20.
 */
public class LambdaExpress {

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    public static void main(String[] args) {
        // 类型声明
        MathOperation addition = (int a, int b) -> a + b;


    }


    interface MathOperation {
        int operation(int a, int b);
    }

    interface GreetingService {
        void sayMessage(String message);
    }

    private int operate(int a, int b, MathOperation mathOperation){
        return mathOperation.operation(a, b);
    }
}
