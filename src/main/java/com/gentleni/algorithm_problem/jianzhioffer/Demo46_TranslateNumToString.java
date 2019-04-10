package com.gentleni.algorithm_problem.jianzhioffer;

/**
 * Created by GentleNi
 * Date 2019/3/4.
 */
public class Demo46_TranslateNumToString {
    /**
     * 若第i个数字和第i+1个数字拼接成的数字在10~25范围内，则递归式子为：
     f(i)=f(i+1)+f(i+2)
     f(i)=f(i+1)+f(i+2)

     2）否则
     f(i)=f(i+1)
     f(i)=f(i+1)
     为了防止重复计算，按i从大到小计算。
     * @param number
     * @return
     */
    private static int getTranslationCount(int number)
    {
        if (number < 0) return 0; //负数默认可翻译个数为0
        return translationCount(String.valueOf(number));
    }

    private static int translationCount(String number) {
        int length = number.length();
        int[] countRecords = new int[length];
        //只有一个数字就只有一种翻译方式
        countRecords[length - 1] = 1;
        int count;
        for (int i = length - 2; i >= 0; i--) {
            //f(i+1)
            count = countRecords[i+1];
            int digit1 = number.charAt(i) - '0';
            int digit2 = number.charAt(i+1) - '0';
            int connectNumber = digit1 * 10 + digit2;
            if (connectNumber >= 10 && connectNumber <= 26) {
                if (i < length - 2) {
                    count += countRecords[i+2];
                } else if (i == length - 2) {
                    count += 1; //拼接的只有一种翻译方式
                }
            }
            countRecords[i] = count;
        }
        count = countRecords[0];
        return count;
    }
}
