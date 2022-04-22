package com.wxp.algrithm.normalQuestion;

import com.wxp.common.ConstantsTest;

import java.util.Arrays;

/**
 * @description: 找出只出现一次的元素
 * @author: wxp
 * @time: 2022/4/7 19:45
 */
public class OnlyOnceArray_136 {

    public static void main(String[] args) {
        int[] arr = new int[]{4,1,2,1,2};
        System.out.println(ConstantsTest.GSON.toJson(singleNumber(arr)));
    }

    public static int singleNumber(int[] nums) {
        if(nums == null || nums.length == 0){
            return 0;
        }
        Arrays.sort(nums);
        for(int i = 0 ; i < nums.length ; i = i+2){
            if( i+1 < nums.length && nums[i] != nums[i+1]){
                return nums[i];
            }
        }
        return nums[nums.length - 1];
    }
}
