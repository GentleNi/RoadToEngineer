package com.gentleni.algorithm.jianzhioffer;

/**
 * Created by GentleNi
 * Date 2019/2/20.
 */
public class ZDemo44_GetDigitAtIndex {

    public int getDigitAtIndex(int index) {
        if (index < 0)
            return -1;
        int place = 1;  // 1 表示个位，2 表示 十位...
        while (true) {
            int amount = getAmountOfPlace(place);//该位数的数字的总个数
            int totalAmount = amount * place;//该位数的数字的字符对应的总个数
            if (index < totalAmount)//说明该index对应的数字在这个范围内
                return getDigitAtIndex(index, place);
            index -= totalAmount;//继续进位道下一个范围
            place++;
        }
    }

    /**
     * place 位数的数字组成的字符串长度
     * 10, 90, 900, ...
     */
    private int getAmountOfPlace(int place) {
        if (place == 1)
            return 10;
        return (int) Math.pow(10, place - 1) * 9;
    }

    /**
     * place 位数的起始数字
     * 0, 10, 100, ...
     */
    private int getBeginNumberOfPlace(int place) {
        if (place == 1)
            return 0;
        return (int) Math.pow(10, place - 1);
    }

    /**
     * 在 place 位数组成的字符串中，第 index 个数
     */
    private int getDigitAtIndex(int index, int place) {
        int beginNumber = getBeginNumberOfPlace(place);//例如 10
        int shiftNumber = index / place;//例如 79，代表在10-99范围内的第79个数字
        String number = (beginNumber + shiftNumber) + "";//10+79 = 89
        int count = index % place;//79 % 2 == 1
        return number.charAt(count) - '0';//对应的89的第1位，也就是9
    }
}
