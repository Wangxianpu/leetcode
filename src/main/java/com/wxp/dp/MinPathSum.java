package com.wxp.dp;

/**
 * @Author : shampoowang
 * @Date:Created : 2018/8/9 12:52
 * @Description : 64. 最小路径和
 */
public class MinPathSum {
    public int minPathSum(int[][] grid) {
        if(grid == null || grid.length == 0){
            return 0;
        }
        int m = grid.length;
        int n = grid[0].length;

        int[][] dp = new int[m][n];

        for(int i = 0 ;i < m ; i++){
            for(int j = 0 ; j < n ; j++){
                if(i == 0 && j == 0){
                    dp[i][j] = grid[i][j];
                    continue;
                }
                if(i == 0){
                    dp[i][j] = dp[i][j-1] + grid[i][j];
                    continue;
                }
                if(j == 0){
                    dp[i][j] = dp[i-1][j] + grid[i][j];
                    continue;
                }
                if(dp[i][j-1] < dp[i-1][j]){
                    dp[i][j] = dp[i][j-1] + grid[i][j];
                }else{
                    dp[i][j] = dp[i-1][j] + grid[i][j];
                }
            }
        }
        return dp[m-1][n-1];
    }


    public static int minPathSum2(int[][] grid) {
        if(grid == null || grid.length == 0){
            return 0;
        }

        int m = grid.length;
        int n = grid[0].length;

        int[] dp = new int[m];

        for(int i = 0 ; i < m ; i++){
            for(int j =0 ; j < n ; j++){
                if(i == 0 && j == 0){
                    dp[0] = grid[0][0];
                    continue;
                }
                if(i == 0){
                    dp[i] = dp[i] + grid[i][j];
                    continue;
                }
                if(dp[i-1] < dp[i]){
                    dp[i] = dp[i-1] + grid[i][j];
                }else{
                    dp[i] = dp[i] + grid[i][j];;
                }
            }
        }

        return dp[m-1];
    }

    public static void main(String[] args) {
        int[][] grid = new int[][]{{1,2},{1,1}};
        minPathSum2(grid);
    }

}