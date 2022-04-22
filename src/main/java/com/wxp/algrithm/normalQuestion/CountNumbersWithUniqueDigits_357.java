package com.wxp.algrithm.normalQuestion;

import java.util.HashSet;
import java.util.Set;

/**
 * @description: 统计各位数字都不同的数字个数
 * @author: wxp
 * @time: 2022/4/11 10:09
 */
public class CountNumbersWithUniqueDigits_357 {

    public static void main(String[] args) {
        int n = 4;
        System.out.println(countNumbersWithUniqueDigits(n));
    }



    public static int countNumbersWithUniqueDigits(int n) {
        if (n == 0) {
            return 1;
        }
        int result = 10;
        int count = 9;
        for (int i = 1; i < n;i++) {
            result += count*(10 - i);
            count *= (10 - i);
        }
        return result;
    }

    public static int countNumbersWithUniqueDigits_2(int n) {
        int maxValue = (int) Math.pow(10, n);
        int res = 0;
        int[] cars = new int[n];
        for (int i = 0; i < maxValue; i++) {
            if (!isSameDigit(i,cars,n)) {
                res++;
            }
        }
        return res;
    }

    private static boolean isSameDigit(int num,int cars[],int n) {
        for(int i = 0; i < n ; i++){
            cars[i] = 0;
        }
        if(num < 10){
            return false;
        }
        //当前位数
        int index = 1;
        int remainder_pre = num % 10;
        cars[0] = remainder_pre;
        int remainder_aft = 0;
        for (int i = 1; i < n; i++) {
            num =  num / 10;
            remainder_aft = num % 10;
            index++;
            cars[i] = remainder_aft;
            if (hasSameValue(cars,index)) {
                return true;
            }
        }
        return false;
    }

    private static boolean hasSameValue(int[] cars,int index) {
        Set set = new HashSet();
        for (int i = 0; i< index; i++) {
            if(set.contains(cars[i])){
                return true;
            }
            set.add(cars[i]);
        }
        return false;
    }
}
