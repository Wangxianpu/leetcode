package com.wxp.algrithm.normalQuestion;

/**
 * @description: 三维形体投影面积
 *  v = grid[i,j]
 *  S_yz: if v > 0      sum(i_v)
 *  S_xz: if v > 0      sum(j_v)
 *  S_xy: if v > 0      sum(i,j)
 * @author: wxp
 * @time: 2022/4/26 21:16  [[1,4],[1,1]]
 */
public class ProjectionArea_883 {
    public static void main(String[] args) {
        int[][] grid = new int[][]{ {1,4},
                                    {1,1}};
        System.out.println(projectionArea(grid));
    }

    public static int projectionArea(int[][] grid) {
        if(null == grid || grid.length == 0 ){
            return 0;
        }
        int S_xy = 0;
        int S_xz = 0;
        int S_yz = 0;
        //行中最大值
        int row_v = grid[0][0];
        //列中最大值
        int[] col_v = grid[0];

        for (int i = 0; i < grid.length ; i++){
            //重置
            row_v = 0;
            for (int j = 0; j < grid[i].length; j++) {
                int v = grid[i][j];
                if(v > 0){
                    S_xy += 1;
                }
                //找出每列中的最大值
                if(i > 0){
                    col_v[j] = Math.max(col_v[j],grid[i][j]);
                }
                //获取当前行最大值
                row_v = Math.max(row_v,v);
            }
            //计算xz维度的面积
            S_xz += row_v;
        }
        //计算yz维度的面积
        for (int j : col_v) {
            S_yz += j;
        }
        return S_xy+S_xz+S_yz;
    }
}
