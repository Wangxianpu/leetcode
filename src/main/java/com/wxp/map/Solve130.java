package com.wxp.map;

/**
 * Created by 10521 on 2018/9/6.
 */
public class Solve130 {
    int[] qx = new int[100000];
    int[] qy = new int[100000];

    boolean isBack ;

    boolean[][] v = new boolean[1000][1000];


    public void solve(char[][] grid){
        if(grid == null || grid.length == 0 || grid[0].length == 0) return;
        int n = grid.length;
        int m = grid[0].length;
        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < m ; j++){
                if(grid[i][j] == 'O' && !v[i][j]){
                    floodFill(grid,i,j,n,m);
                }
            }
        }
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
        isBack = false;
        qx[0] = x;
        qy[0] = y;
        grid[x][y] ='X';
        while(h < r){
            r = check(qx[h]-1,qy[h],r,grid,n,m);
            r = check(qx[h]+1,qy[h],r,grid,n,m);
            r = check(qx[h],qy[h]+1,r,grid,n,m);
            r = check(qx[h],qy[h]-1,r,grid,n,m);
            h++;
        }
        if(isBack){
            for(int i = 0 ; i < r ; i++){
                grid[qx[i]][qy[i]] = 'O';
            }
        }

    }

    private int check(int x, int y, int r,char[][] grid, int n, int m) {
        if(x >=0 && x < n && y >= 0 && y < m){
            if(grid[x][y] == 'O'){
                v[x][y] = true;
                grid[x][y] = 'X';
                qx[r] = x;
                qy[r] = y;
                r++;
            }
        }else{
            isBack = true;
        }
        return r;
    }

}
