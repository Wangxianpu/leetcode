package com.wxp.map;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by 10521 on 2018/9/5.
 * 200. 岛屿的个数
 */
public class NumIslands {

    int[] qx = new int[100000];
    int[] qy = new int[100000];


    public int numIslands(char[][] grid){
        if(grid == null || grid.length == 0 || grid[0].length == 0) return 0;
        int n = grid.length;
        int m = grid[0].length;
        int ans = 0;
        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < m ; j++){
                if(grid[i][j] == '1'){
                    floodFill(grid,i,j,n,m);
                    ans++;
                }
            }
        }
        return ans;
    }

    /**
     * 填充队列
     * @param grid
     * @param x
     * @param y
     * @param n
     * @param m
     */
    private void floodFill(char[][] grid, int x, int y, int n, int m) {
        int h = 0; //头
        int r = 1; //尾
        qx[0] = x;
        qy[0] = y;
        grid[x][y] ='0';
        while(h < r){
            r = check(qx[h]-1,qy[h],r,grid,n,m);
            r = check(qx[h]+1,qy[h],r,grid,n,m);
            r = check(qx[h],qy[h]+1,r,grid,n,m);
            r = check(qx[h],qy[h]-1,r,grid,n,m);
            h++;
        }

    }

    private int check(int x, int y, int r,char[][] grid, int n, int m) {
        if(x >=0 && x < n && y >= 0 && y < m && grid[x][y] == '1'){
            grid[x][y] = '0';
            qx[r] = x;
            qy[r] = y;
            r++;
        }
        return r;
    }


    /**
     * 第二种解法，深度优先搜索
     */

    private int m;
    private int n;
    public int numIslands2(char[][] grid) {
        int res = 0;
        m = grid.length;
        if (m == 0) return 0;
        n = grid[0].length;
        for (int i = 0;i < m;i++) {
            for (int j = 0;j < n;j++) {
                if (grid[i][j] == '1') {
                    dfs(grid,i,j);
                    res++;
                }
            }
        }
        return res;
    }
    private void dfs(char[][] grid,int i,int j) {
        if (i < 0 || j < 0 || i >= m || j >= n || grid[i][j] == '0') return;
        grid[i][j] = '0';
        dfs(grid,i,j + 1);
        dfs(grid,i,j - 1);
        dfs(grid,i + 1,j);
        dfs(grid,i - 1,j);
    }
}
