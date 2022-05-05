package com.wxp.algrithm.normalMid;

/**
 * @description: 乘积小于K的子数组
 *  给你一个整数数组 nums 和一个整数 k ，
 *  请你返回子数组内所有元素的乘积严格小于 k 的 "连续" 子数组的数目。
 *  f(n) =
 *      f(n-1) + 1
 *      f(n-1)
 * @author: wxp
 * @time: 2022/5/5 21:52
 * @thought: 双指针
 */
public class NumSubArrayProductLessThanK_713 {

    public static void main(String[] args) {
        int[] nums = new int[]{10,5,2,6};
        System.out.println(numSubarrayProductLessThanK(nums,100));
    }

    private static int numSubarrayProductLessThanK(int[] nums, int k) {
        if(k == 0){
            return 0;
        }
        int targetNum = 0;
        int i = 0, j = 0;
        //记录乘积
        int prod = 1;
        for( ;i < nums.length ; i++){
            prod *= nums[i];

            //如果乘积大于等于k,或者i,j两个指针相遇
            while(j <= i && prod >= k){
                //如果乘积大于k，则左指针需要向后移动，并将相应位置的值除掉，以便进行后续的匹配
                prod /= nums[j];
                j++;
            }
            targetNum += i - j +1;
        }
        return targetNum;
    }

}
