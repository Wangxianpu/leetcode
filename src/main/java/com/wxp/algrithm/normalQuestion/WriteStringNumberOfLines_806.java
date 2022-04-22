package com.wxp.algrithm.normalQuestion;

import com.wxp.common.ConstantsTest;

/**
 * @description: 806 写字符串所需要的行数
 * @author: wxp
 * @time: 2022/4/12 21:54
 */
public class WriteStringNumberOfLines_806 {
    public static void main(String[] args) {
        int[] widths = new int[]{4,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10};
        String s = "bbbcccdddaaa";
        System.out.println(ConstantsTest.GSON.toJson(numberOfLines(widths,s)));
    }

    public static int[] numberOfLines(int[] widths, String s) {
        int[] res = new int[2];
        int rows = 1;
        int width = 0;
        for (char c : s.toCharArray()){
            int key = c - 'a';
            width += widths[key];
            if(width > 100){
                width = widths[key];
                rows++;
            }
        }
        res[0] = rows;
        res[1] = width;
        return res;
    }
}
