package com.wxp.dp;

/**
 * @Author : shampoowang
 * @Date:Created : 2018/8/7 18:35
 * @Description : 动态规划-爬楼梯问题
 */
public class ClimbStairs {
    public int climbStairs(int n){
        if(n == 1 ){
            return 1;
        }
        int[] dp = new int[n];
        dp[0] = 1;
        dp[1] = 2;
        for(int i = 2; i < n ; i++){
            dp[i] = dp[i-1] + dp[i-2];
        }
        return dp[n-1];
    }
}