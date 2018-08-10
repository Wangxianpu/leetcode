package com.wxp.dp;

/**
 * @Author : shampoowang
 * @Date:Created : 2018/8/8 14:17
 * @Description : 63. 不同路径 II
 */
public class UniquePathsWithObstacles {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if(obstacleGrid == null ||obstacleGrid.length == 0){
            return 0;
        }
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[][] dp = new int[m][n];
        for(int i = 0 ; i < m;i++){
            for(int j = 0 ; j < n ; j++){
                if(i == 0 && j == 0 ){
                    dp[i][j] = obstacleGrid[i][j] == 0?1:0;
                    continue;
                }
                if(i == 0 || j == 0){
                    if(obstacleGrid[i][j] != 1){
                        if(i == 0){
                            dp[i][j] = dp[i][j-1];
                        }
                        if(j == 0){
                            dp[i][j] = dp[i-1][j];
                        }
                    } else
                        dp[i][j] = 0;
                    continue;
                }
                //遇到障碍
                if(obstacleGrid[i][j-1] == 1 && obstacleGrid[i-1][j] == 1){
                    dp[i][j] = 0;
                    continue;
                }
                if(obstacleGrid[i][j-1] == 1){
                    dp[i][j] = dp[i-1][j];
                    continue;
                }
                if(obstacleGrid[i-1][j] == 1){
                    dp[i][j] = dp[i][j-1];
                    continue;
                }
                dp[i][j] = dp[i-1][j] + dp[i][j-1];
            }
        }
        return  obstacleGrid[m-1][n-1] == 1?0:dp[m-1][n-1];
    }
}