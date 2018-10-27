package com.wxp.tree;

/**
 * 733. 图像渲染
 * Created by 10521 on 2018/10/27.
 */
public class FloodFillImage {
    int newNum;
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        if(image == null ||image.length < 1 || image[0].length < 1){
            return null;
        }
        //图像的 y 轴  -> 行数
        int row = image.length;
        //图像的 x 轴 -> 列数
        int col = image[0].length;

        if(sr < 0 || sr >= row || sc < 0 || sc >= col){
            return null;
        }

        newNum = newColor;

        //带填充的目标值
        int desc = image[sr][sc];

        if(newNum == desc){
            return image;
        }
        //渲染图片
        fillSeed(desc,image,sr,sc,row,col);
        return image;
    }

    private void fillSeed(int desc, int[][] image, int r, int c,int row,int col) {
        image[r][c] = newNum;
        if((r-1) >= 0 && image[r-1][c] == desc){
            fillSeed(desc,image,r-1,c,row,col);
        }
        if((r+1) < row  && image[r+1][c] == desc){
            fillSeed(desc,image,r+1,c,row,col);
        }
        if((c-1) >= 0 && image[r][c-1] == desc){
            fillSeed(desc,image,r,c-1,row,col);
        }
        if((c+1) < col && image[r][c+1] == desc){
            fillSeed(desc,image,r,c+1,row,col);
        }
    }
}
