package com.wxp.algrithm.normalQuestion;


import com.wxp.common.ConstantsTest;

import java.util.ArrayList;
import java.util.List;

/**
 * @description: 字符最短距离
 * @author: wxp
 * @time: 2022/4/19 21:12
 */
public class ShortestToChar_821 {
    public static void main(String[] args) {
        System.out.println(ConstantsTest.GSON.toJson(shortestToChar("aaab",'b')));
    }
    public static int[] shortestToChar(String s, char c) {

        //返回结果
        int[] res = new int[s.length()];
        //获取字符串中字符c的位置列表
        List<Integer> posList = new ArrayList<>();
        char[] sChars = s.toCharArray();
        for (int i = 0 ; i < sChars.length; i++){
            if(sChars[i] == c){
                posList.add(i);
            }
        }

        int leftPos = posList.get(0);
        int rightPos = -1;
        int cursor = 0;
        if(posList.size() > 1){
            rightPos = posList.get(1);
            cursor = 1;
        }

        for(int j = 0 ; j < sChars.length ; j++){
            if(j > leftPos && j > rightPos && rightPos!= -1){
                //左右位置前移，并将游标向前进一
                leftPos = rightPos;
                if(posList.get(posList.size()-1) > rightPos){
                    rightPos = posList.get(++cursor);
                }
            }
            if(rightPos == -1){
                res[j] = Math.abs(j-leftPos);
            }else{
                res[j] = Math.min(Math.abs(j-leftPos),Math.abs(j-rightPos));
            }
        }
        return res;
    }
}
//[3,2,1,0,1,0,0,1,2,2,1,0]
//[3,2,1,0,1,2,1,1,2,3,4,5]
//[3,2,1,0,1,2,1,1,2,3,4,5]
//[3,2,1,0,1,0,0,1,2,2,1,0]
