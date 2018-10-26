package com.wxp.tree;

import java.util.Stack;

/**
 * 695. 岛屿的最大面积
 * Created by wangxianpu on 2018/10/26.
 */
public class MaxAreaOfIsland {
    Stack<Pair> stack = new Stack<Pair>();
    int max = 0;
    int m = 0;
    int n = 0;
    boolean[][] visited;
    public int maxAreaOfIsland(int[][] grid) {
        if(grid == null ||grid.length <= 0 || grid[0].length <= 0)
            return 0;

        m = grid.length;
        n = grid[0].length;
        visited = new boolean[m][n];
        int count = 0;
        for(int y = 0 ; y < m ;y++){
            for(int x = 0 ; x < n ;x++){
                if(grid[y][x] == 1 && !visited[y][x]){
                    stack.push(new Pair(x, y));
                    count = seedFool(x,y,grid,count+1);
                    if(max < count ){
                        max = count;
                    }
                    count = 0;
                }
            }
        }
        return max;
    }

    //填充岛屿
    private int seedFool(int x, int y, int[][] grid , int count) {
//        if(x < 0||x >= m || y < 0 || y > n){
//            return count;
//        }
        visited[y][x] = true;
        //->left
        if((x-1) >= 0 && !visited[y][x-1] && grid[y][x-1] == 1){
            stack.push(new Pair(x-1, y));
            count = seedFool(x-1,y,grid,count+1);
        }
        //->right
        if((x+1) < n && !visited[y][x+1] && grid[y][x+1] == 1) {
            stack.push(new Pair(x+1, y));
            count = seedFool(x + 1, y, grid,count+1);
        }
        //->up
        if((y-1) >= 0 && !visited[y-1][x] && grid[y-1][x] == 1) {
            stack.push(new Pair(x, y-1));
            count = seedFool(x, y - 1, grid,count+1);
        }
        //->down
        if((y+1) < m && !visited[y+1][x] && grid[y+1][x] == 1) {
            stack.push(new Pair(x, y+1));
            count = seedFool(x, y + 1, grid,count+1);
        }
        if(!stack.isEmpty()){
            Pair pair = stack.pop();
            count = seedFool(pair.x, pair.y, grid,count);
        }
        return count;
    }

    class Pair{
        int x;
        int y;
        public Pair(int x,int y){
            this.x = x ;
            this.y = y ;
        }
    }

    public static void main(String[] args) {
//        int[][] grid = new int[][]{{1,0,0,0,0},{1,1,0,0,0},{0,0,0,1,1},{0,0,0,1,1}};
//        int[][] grid = new int[][]{{1,1},{1,0}};
        int[][] grid = new int[][]{{0,1,0},{1,1,1},{0,1,0}};
        int cnt = new MaxAreaOfIsland().maxAreaOfIsland(grid);
        System.out.println("最大岛屿面积:" + cnt);
    }

}
