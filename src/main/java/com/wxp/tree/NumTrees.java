package com.wxp.tree;

/**
 * Created by 10521 on 2018/8/28.
 * 96. 不同的二叉搜索树
 */
public class NumTrees {
    public int numTrees(int n) {
        int[] dp = new int[n+1];
        if(n == 0 || n == 1){
            return 1;
        }
        dp[0] = 1;
        dp[1] = 1;

        for (int i = 2; i <= n; i++) {
            for (int j = 0; j < i; j++) {
                dp[i] = dp[i] + dp[j] * dp[i - 1 - j];
            }
        }
        return dp[n];
    }
}
