package com.wxp.dp;

/**
 * @Author : shampoowang
 * @Date:Created : 2018/8/7 18:18
 * @Description : 最大子序和
 */
public class MaxSubArray {

    public static int maxSubArray(int[] nums) {
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        int max = dp[0];
        for(int i = 1; i < nums.length ; i++){
            if((dp[i-1] + nums[i]) > nums[i]){
                dp[i] = dp[i-1] + nums[i];
            }else{
                dp[i] = nums[i];
            }
            max = dp[i] > max?dp[i]:max;
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(maxSubArray(new int[]{-2,1,-3,4,-1,2,1,-5,4}));
    }
}