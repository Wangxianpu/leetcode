package com.wxp.dp;

/**
 * @Author : shampoowang
 * @Date:Created : 2018/8/16 14:21
 * @Description : 338. 比特位计数
 */
public class CountBits {
    public int[] countBits(int num) {
        int[] dp = new int[num+1];
        dp[0] = 0;
        for(int i = 1; i <= num ; i++){
            dp[i] = dp[i&(i-1)] +1;
        }
        return dp;
    }
}