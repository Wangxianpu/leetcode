package com.wxp.dp;

/**
 * @Author : shampoowang
 * @Date:Created : 2018/8/7 18:55
 * @Description : 股票买入的最佳时间
 */
public class MaxProfit {
    public int maxProfit(int[] prices){
        int[] dp = new int[prices.length];

        int max = 0;

        if(prices.length <= 1){
            return 0;
        }

        for(int i = 0 ; i < prices.length ; i++){
            if(i ==0){
                dp[0] = 0;
                continue;
            }

            if((dp[i-1] + prices[i]-prices[i-1]) > 0){
                dp[i] = dp[i-1] + prices[i]-prices[i-1];
            }else{
                dp[i] = 0;
            }
            max = dp[i] > max?dp[i]:max;
        }
        return max;
    }
}