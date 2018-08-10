package com.wxp.dp;

/**
 * @Author : shampoowang
 * @Date:Created : 2018/8/9 21:16
 * @Description :  91. 解码方法
 */
public class NumDecodings {
    public static int numDecodings(String s) {
        if (s == "") return 0;
        char[] digit = s.toCharArray();
        int[] dp = new int[digit.length];
        //get dp[0]
        dp[0] = digit[0] == '0' ? 0 : 1;
        if (dp[0] == 0 || digit.length == 1) return dp[0];
        //get dp[1]
        dp[1] = 1;
        if (digit[1] == '0') {
            if (digit[0] >= '3')
                return 0;
        }
        else if (digit[0] == '1' || (digit[0] == '2' && '1' <= digit[1] && digit[1] <= '6'))
            dp[1] = 2;
        //get dp[i]
        for (int i = 2; i < digit.length; i++) {
            if (digit[i] == '0') {
                if (digit[i-1] == '1' || digit[i-1] == '2')
                    dp[i] = dp[i-2];
                else return 0;
            }
            else if (digit[i-1] == '1' || (digit[i-1] == '2' && '1' <= digit[i] && digit[i] <= '6'))
                dp[i] = dp[i-1] + dp[i-2];
            else dp[i] = dp[i-1];
        }
        return dp[digit.length-1];
    }

    public static void main(String[] args) {
        numDecodings("226");
    }

}