package com.wxp.algrithm.normalQuestion;


import com.wxp.common.ConstantsTest;

import java.util.ArrayList;
import java.util.List;

/**
 * @description: 杨辉三角II 根据特定下标返回具体的某一列数据
 * @author: wxp 
 * @time: 2022/4/7 15:09
 */
public class PascalTriangleII_119 {

    public static void main(String[] args) {
        System.out.println(ConstantsTest.GSON.toJson(getRow(0)));
    }

    public static List<Integer> getRow(int rowIndex) {
        List<Integer> resultList = new ArrayList<>();
        //存储临时数据的list
        List<Integer> tmpList ;
        for (int i = 0; i <= rowIndex ; i++) {
            //切换引用,指向上一行的结果
            tmpList = resultList;
            //初始化结果，存储新一行的结果
            resultList = new ArrayList<>();

            for (int j = 0; j <= i; j++) {
                if(j == 0 || j == i){
                    resultList.add(j,1);
                    continue;
                }
                resultList.add(j,tmpList.get(j-1) + tmpList.get(j));
            }
        }
        return resultList;
    }
}
