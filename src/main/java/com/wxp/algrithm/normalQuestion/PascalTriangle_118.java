package com.wxp.algrithm.normalQuestion;

import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

/**
 * @description: 杨辉三角
 * @author: wxp
 * @time: 2022/4/7 14:54
 */
public class PascalTriangle_118 {

    public static void main(String[] args) {
        Gson gson = new Gson();

        System.out.println(gson.toJson(generate(1)));

    }

    public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> resList = new ArrayList<>();
        if(numRows <= 0){
            return resList;
        }

        //第一行数据
        List<Integer> firstList = new ArrayList<>();
        firstList.add(1);
        resList.add(firstList);
        //遍历将后续几列数据全部生成,因为第一行已经创建了，所以直接从下标1开始
        for (int i = 1; i < numRows; i++) {

            List<Integer> list = new ArrayList<>();

            for (int j = 0; j <= i; j++) {
                //针对杨辉三角的边设置为1
                if(j == 0 || j == i ){
                    list.add(1);
                    continue;
                }
                //杨辉三角的值 arr[i][j]= arr[i-1][j-1] +  arr[i-1][j]
                list.add(resList.get(i-1).get(j-1) + resList.get(i-1).get(j));
            }
            resList.add(list);
        }
        return resList;
    }

}
