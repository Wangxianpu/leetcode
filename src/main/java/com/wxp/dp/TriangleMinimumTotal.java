package com.wxp.dp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by 10521 on 2018/8/11.
 *  120. 三角形最小路径和
 */
public class TriangleMinimumTotal {
    public int minimumTotal(List<List<Integer>> triangle) {
        if(triangle == null || triangle.size() == 0) return 0;
        int n = triangle.size();
        int[][] dp = new int[n][n];
        dp[0][0] = triangle.get(0).get(0);

        for(int i = 1; i < n ; i++){
            for(int j = 0; j <= i ; j++ ){
                if(j == 0){
                    dp[i][j] = dp[i-1][j] + triangle.get(i).get(j);
                }else if(j == i){
                    dp[i][j] = dp[i-1][j-1] + triangle.get(i).get(j);
                }else {
                    if(dp[i-1][j-1] < dp[i-1][j]){
                        dp[i][j] = dp[i-1][j-1] + triangle.get(i).get(j);
                    }else{
                        dp[i][j] = dp[i-1][j] + triangle.get(i).get(j);
                    }
                }
            }
        }
        int minSum = dp[n-1][0];
        for(int i = 1 ; i < n ; i++){
            if(minSum > dp[n-1][i]){
                minSum = dp[n-1][i];
            }
        }
        return minSum;
    }


    public static int minimumTotal2(List<List<Integer>> triangle) {
        if(triangle == null || triangle.size() == 0) return 0;
        int n = triangle.size();
        int[] dp = new int[n];
        dp[0] = triangle.get(0).get(0);
        for(int i = 1; i < n ; i++){
            for(int j = i; j >= 0 ; j-- ){
                if(j == 0){
                    dp[j] = dp[j] + triangle.get(i).get(j);
                }else if(j == i){
                    dp[j] = dp[j-1] + triangle.get(i).get(j);
                }else {
                    if(dp[j-1] < dp[j]){
                        dp[j] = dp[j-1] + triangle.get(i).get(j);
                    }else{
                        dp[j] = dp[j] + triangle.get(i).get(j);
                    }
                }
            }
        }
        int minSum = dp[0];
        for(int i = 1 ; i < n ; i++){
            if(minSum > dp[i]){
                minSum = dp[i];
            }
        }
        return minSum;
    }

    public static void main(String[] args) {
        List<List<Integer>> sums = new ArrayList<List<Integer>>();
        List<Integer> num1 = Arrays.asList(2);
        List<Integer> num2 = Arrays.asList(3,4);
        List<Integer> num3 = Arrays.asList(6,5,7);
        List<Integer> num4 = Arrays.asList(4,1,8,3);
        sums = Arrays.asList(num1,num2,num3,num4);
        minimumTotal2(sums);
    }
}
