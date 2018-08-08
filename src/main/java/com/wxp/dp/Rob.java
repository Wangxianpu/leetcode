package com.wxp.dp;

/**
 * @Author : shampoowang
 * @Date:Created : 2018/8/8 9:54
 * @Description : 算法 打家劫舍 leetcode 198
 */
public class Rob {
    public int rob(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        if(nums.length == 1) return nums[0];
        if(nums.length == 2) return nums[0]>nums[1]?nums[0]:nums[1];
        if(nums.length == 3) return (nums[0]+nums[2])>nums[1]?(nums[0]+nums[2]):nums[1];

        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        dp[1] = nums[1];
        dp[2] = nums[0]+nums[2];
        for(int i = 3; i < nums.length; i++){
            if(dp[i-2]>dp[i-3]){
                dp[i] = dp[i-2] + nums[i];
            }else{
                dp[i] = dp[i-3] + nums[i];
            }
        }
        return dp[nums.length - 1] > dp[nums.length - 2] ? dp[nums.length - 1] : dp[nums.length - 2];
    }


    public int rob2(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        if(nums.length == 1) return nums[0];
        if(nums.length == 2) return Math.max(nums[0],nums[1]);
        int res_1 = Math.max(nums[0],nums[1]);
        int res_2 = nums[0];
        int i = 2;
        while(i < nums.length){
            int res = Math.max(res_2 + nums[i],res_1);
            res_2 = res_1;
            res_1 = res;
            i++;
        }
        return res_1;
    }
}