package com.wxp.algrithm.normalQuestion;

/**
 * @description:
 * @author: wxp
 * @time: 2022/4/4 10:36
 */
public class ImplementStrStr_28 {

    public static void main(String[] args) {

        System.out.println(strStr("h","hll"));
    }

    /**
     *  从str1中求出第一次出现str2的下标
     */
    public static int strStr(String haystack, String needle) {
        if(haystack == null || needle == null){
            return 0;
        }
        if(needle.length() == 0){
            return 0;
        }

        char[] char1 = haystack.toCharArray();
        char[] char2 = needle.toCharArray();

        for (int i = 0; i < char1.length; i++) {
            //str2下标
            int j = 0;
            //str1下标，用于比较
            int index = i;
            while(index < char1.length && char1[index] == char2[j]){
                if(j == char2.length - 1){
                    return i;
                }
                index++;
                j++;
            }
        }
        return -1;
    }

}
