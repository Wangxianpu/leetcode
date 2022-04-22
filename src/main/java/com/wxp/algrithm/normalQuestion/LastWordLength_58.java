package com.wxp.algrithm.normalQuestion;

/**
 * @description:
 * @author: wxp
 * @time: 2022/4/4 11:47
 */
public class LastWordLength_58 {

    public static void main(String[] args) {
        System.out.println(lengthOfLastWord("this"));
    }

    public static int lengthOfLastWord(String s) {
        if(s == null || s.length() == 0){
            return 0;
        }

        char[] chars = s.toCharArray();

        int lastBlankLength = 0;
        while( lastBlankLength < chars.length - 1 && chars[chars.length - 1 - lastBlankLength] == ' ' ){
            lastBlankLength++;
        }

        int leftLength = chars.length - lastBlankLength;

        for (int i = leftLength - 1; i >= 0 ; i--) {
            if (' ' == chars[i]){
                return leftLength - 1 - i;
            }
        }
        return leftLength;
    }
}
