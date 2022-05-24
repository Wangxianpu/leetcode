package com.wxp.algrithm.normalQuestion;

/**
 * @description: 812 ： 最大三角形面积
 *  p1：（x1,y1） p2:(x2,y2) p3:(x3,y3)
 *  S = |x1y2+x2y3+x3y1-x1y3-x2y1-x3y2|/2
 *
 * @author: wxp
 * @time: 2022/5/15 16:53
 */
public class LargestTriangleArea_812 {
    public static void main(String[] args) {
        //[[0,0],[0,1],[1,0],[0,2],[2,0]]  [0,0] [0,2] [2,0]
        //[[1,0],[0,0],[0,1]]
//        int[][] points = new int[][]{{0,0},{0,1},{1,0},{0,2},{2,0}};
        int[][] points = new int[][]{{0,0},{0,1},{1,0}};
        System.out.println(largestTriangleArea(points));
    }

    public static double largestTriangleArea(int[][] points){
        if(null == points || points.length < 3){
            return 0;
        }
        double maxS = 0;
        int len = points.length;
        for (int i = 0; i < len ; i++) {
            for (int j = i+1; j < len && j>i; j++) {
                for (int k = j+1; k < len && k > j ; k++) {
                    maxS = Math.max(maxS,(double)Math.abs(
                            points[i][0]*points[j][1] + points[j][0]*points[k][1] + points[k][0]*points[i][1]
                            - points[i][0]*points[k][1] - points[j][0]*points[i][1] - points[k][0]*points[j][1]
                    )/2);
                }
            }
        }
        return maxS;
    }

}
