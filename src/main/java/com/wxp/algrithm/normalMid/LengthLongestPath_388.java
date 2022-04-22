package com.wxp.algrithm.normalMid;


import java.util.ArrayList;

/**
 * @description: 文件的最长绝对路径
 * @author: wxp
 * @time: 2022/4/20 22:23
 */
public class LengthLongestPath_388 {
    public static void main(String[] args) {
        String input = "file1.txt\nfile2.txt\nlongfile.txt";
//        String input = "dir\n\tsubdir1\n\t\tfile1.ext\n\t\tsubsubdir1\n\tsubdir2\n\t\tsubsubdir2\n\t\t\tfile2.ext";
        System.out.println(lengthLongestPath(input));
    }

    public static int lengthLongestPath(String input) {
        int maxLength = 0;   // 记录文件的最大长度
        char[] chars = input.toCharArray(); // 获取所有字符
        ArrayList<Integer> integers = new ArrayList<>();  // 用于记录当前文件前置目录的长度
        int index = 0;       // 目录层级
        int length = 0;      // 当前文件的全路径长度
        int strLength = 0;   // 当前目录或文件的长度
        boolean end = false; // 是否触发文件结尾
        for (char aChar : chars) {
            if (aChar == '\n') {
                integers.add(index, strLength);     // 中间插入，判定长度用set也一样
                if (end) {   // 上一个文件结束
                    length += integers.get(index);  // 计算文件全路径长度
                    maxLength = Math.max(maxLength, length);
                    end = false;  // 文件长度计算完成
                }
                index = 0;     // 重置层级
                length = 0;    // 重置文件全路径长度
                strLength = 0; // 重置目录或文件长度
            } else if (aChar == '\t') {  // 增加层级
                length += integers.get(index) + 1;  // 计算全路径长度
                index++;
            } else if (aChar == '.') {
                end = true;  // 触发文件结尾操作
                strLength++; // 文件名的一部分
            } else {
                strLength++; // 文件或目录名的一部分
            }
        }
        if (end) {
            length += strLength;  // 全路径长度
            maxLength = Math.max(maxLength, length);
        }
        return maxLength;
    }

//
//    static int longestPath = 0;
//
//    public static int lengthLongestPath(String input) {
//        //如果传入路径中不包含文件，直接返回0
//        if(!input.contains(".")){
//            return 0;
//        }
//        //如果传入路径是一个文件，直接返回文件长度即可
//        if(!input.contains("\n")){
//            return input.length();
//        }
//
//        String[] pathArr = input.split("\n");
//        //保留每一级别路径的长度
//        int[] pathLengthArr = new int[pathArr.length];
//        //记录目录级别
//        int pathLevel = 0;
//        for (String s : pathArr) {
//            String curPath = s;
//            //如果不是文件，则保存当前层级的路径长度
//            if (!curPath.contains(".")) {
//                //判断当前路径的层级
//                int curLevel = 0;
//                while (curPath.startsWith("\t")) {
//                    curLevel++;
//                    curPath = curPath.substring(1);
//                }
//                //更新当前目录层级
//                pathLevel = curLevel;
//                //记录当前路径的长度
//                pathLengthArr[pathLevel] = curPath.length();
//            }
//            //如果当前路径是文件
//            if (curPath.contains(".")) {
//                longestPath = Math.max(longestPath, getPathLength(pathLevel, curPath, pathLengthArr));
//            }
//        }
//        return longestPath;
//    }
//
//    //如果当前路径是文件，则统计当前文件的绝对路径长度。
//    private static int getPathLength(int pathLevel, String curPath, int[] pathLengthArr) {
//        int pathLength = 0;
//        for(int i = 0; i <= pathLevel ; i++){
//            pathLength +=  pathLengthArr[i];
//        }
//        return pathLength + curPath.length();
//    }

}
