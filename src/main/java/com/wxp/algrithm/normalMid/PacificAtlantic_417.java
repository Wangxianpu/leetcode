package com.wxp.algrithm.normalMid;

import java.util.ArrayList;
import java.util.List;

/**
 * @description: 417 太平洋，大西洋水流问题
 * @author: wxp
 * @time: 2022/4/27 21:41
 */
public class PacificAtlantic_417 {
    public static void main(String[] args) {
//        int[][] heights = new int[][]{{1,2,2,3,5},{3,2,3,4,4},{2,4,5,3,1},{6,7,1,4,5},{5,1,1,2,4}};
//        int[][] heights = new int[][]{{2,1},{1,2}};
        int[][] heights = new int[][]{{1,2,3},{8,9,4},{7,6,5}};
        System.out.println(pacificAtlantic(heights));
    }

    /**
     * 思路：先标记出所有可以流入太平洋，然后再标记可以流进大西洋的合集
     *  1、太平洋：
     *      从grid[0][0]开始搜索，沿着右/下方向延伸，如果grid[i][j] >= grid[cur_i][cur_j] (cur为当前节点)
     *      则成功下沿。知道不能遍历位置，将所有搜索过的节点标记为可以流入太平洋。
     *  2、大西洋
     *      从grid[m-1][n-1]开始向上/左方向搜索，同理进行标记
     *  3、合计
     *      同时被太平洋和大西洋标记的土地，则满足条件
     *
     * @param heights
     * @return
     */
    public static List<List<Integer>> pacificAtlantic(int[][] heights) {
        List<List<Integer>> res = new ArrayList<>();
        if(null == heights || heights.length == 0 ){
            return res;
        }

        int m = heights.length;
        int n = heights[0].length;
        if(m == 1 || n == 1){
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    List<Integer> tmpList = new ArrayList<>();
                    tmpList.add(i);
                    tmpList.add(j);
                    res.add(tmpList);
                }
            }
            return res;
        }
        int[][] fillPacificGird = new int[m][n];
        int[][] fillAtlanticGrid = new int[m][n];
        //对边缘进行处理
        for (int i = 0 ; i < m ; i++){
            for (int j = 0 ; j < n ; j++){
                //左上边初始化可以流入太平洋
                if(i == 0 || j == 0){
                    fillPacificGird[i][j] = 1;
                }
                //右下角初始化可以流入大西洋
                if( i == m -1 || j == n - 1){
                    fillAtlanticGrid[i][j] = 1;
                }
            }
        }

        //标记出能够流入到太平洋的土地
        for (int i = 0 ; i < m ; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 || j == 0) {
                    markPacificGrid(heights, i, j, fillPacificGird);
                }
            }
        }

        //标记出能够流入到大西洋的土地
        for (int i = 0 ; i < m ; i++) {
            for (int j = 0; j < n; j++) {
                if ( i == m -1 || j == n - 1 ) {
                    markAtlanticGrid(heights, i, j, fillAtlanticGrid);
                }
            }
        }


        //如果同时标记能够流入太平洋和大西洋，则符合结果
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if(fillAtlanticGrid[i][j] > 1 && fillPacificGird[i][j] > 1){
                    List<Integer> tmpList = new ArrayList<>();
                    tmpList.add(i);
                    tmpList.add(j);
                    res.add(tmpList);
                }
            }
        }
        return res;
    }

    private static void markAtlanticGrid(int[][] heights, int x, int y, int[][] fillGird) {
        //如果超过了边界，则中断返回
        if(x < 0 || y < 0 ){
            return;
        }
        if(fillGird[x][y] > 1){
            return;
        }
        //如果已经无法向左上扩张，则中断返回
        if((x+1 < heights.length &&  heights[x][y] < heights[x+1][y]  && fillGird[x+1][y] > 0 )
                && (y+1 < heights[x].length && heights[x][y] < heights[x][y+1]  && fillGird[x][y+1] > 0)){
            return;
        }
        fillGird[x][y] += 1;
        markAtlanticGrid(heights,x-1,y,fillGird);
        markAtlanticGrid(heights,x,y-1,fillGird);
        markAtlanticGrid(heights,x+1,y,fillGird);
        markAtlanticGrid(heights,x,y+1,fillGird);
    }

    private static void markPacificGrid(int[][] heights, int x, int y, int[][] fillGird) {
        //如果超过了边界，则中断返回
        if(x >= heights.length  || y >= heights[0].length){
            return;
        }
        if(fillGird[x][y] > 1){
            return;
        }
        //如果已经无法右向下扩张，则中断返回
        if((x-1 >=0 && heights[x][y] < heights[x-1][y] && fillGird[x-1][y] > 0)
                && (y-1 >= 0 && heights[x][y] < heights[x][y-1]  && fillGird[x][y-1] > 0) ){
            return;
        }
        fillGird[x][y] += 1;
        markPacificGrid(heights,x+1,y,fillGird);
        markPacificGrid(heights,x,y+1,fillGird);
        markPacificGrid(heights,x-1,y,fillGird);
        markPacificGrid(heights,x,y-1,fillGird);
    }
}
