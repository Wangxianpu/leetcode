package com.wxp.algrithm.normalQuestion;

import com.google.gson.Gson;

/**
 * @description:
 * @author: wxp
 * @time: 2022/4/4 13:27
 */
public class IntegerArrayPlusOne_66 {
    public static void main(String[] args) {

        int[] nums = new int[]{0};
        Gson gson = new Gson();

        System.out.println(gson.toJson(plusOne(nums)));
    }

    static boolean isCarry = false;

    public static int[] plusOne(int[] digits) {
        addOne(digits,digits.length - 1 );
        if (isCarry){
            int[] newDigits = new int[digits.length + 1];
            newDigits[0] = 1;
            return newDigits;
        }
        return digits;
    }

    private static void addOne(int[] digits, int pos) {
        if(pos < 0){
            isCarry = true;
            return;
        }
        int num = digits[pos] + 1;
        if(num == 10){
            digits[pos] = 0;
            addOne(digits,pos - 1);
        }else{
            digits[pos] = num;
        }
    }
}
