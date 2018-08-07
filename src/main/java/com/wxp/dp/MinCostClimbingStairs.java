package com.wxp.dp;

/**
 * @Author : shampoowang
 * @Date:Created : 2018/8/7 19:13
 * @Description : 使用最小花费爬楼梯
 */
public class MinCostClimbingStairs {
    public int minCostClimbingStairs(int[] cost) {
        if(cost.length == 1){
            return cost[0];
        }
        if(cost.length == 2){
            return cost[0]>cost[1]?cost[1]:cost[0];
        }

        int[] dp = new int[cost.length];
        dp[0] = cost[0];
        dp[1] = cost[1];
        for(int i = 2; i < cost.length ; i++){
            if(dp[i-1] > dp[i-2]){
                dp[i] = dp[i-2] + cost[i];
            }else{
                dp[i] = dp[i-1] + cost[i];
            }
        }
        return dp[dp.length-1]>dp[dp.length-2]?dp[dp.length-2]:dp[dp.length-1];
    }
}