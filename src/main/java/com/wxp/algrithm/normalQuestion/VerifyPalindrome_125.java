package com.wxp.algrithm.normalQuestion;

/**
 * @description: 验证给定的字符串是否为回文字符串
 * @author: wxp
 * @time: 2022/4/7 15:43
 */
public class VerifyPalindrome_125 {


    public static void main(String[] args) {
        //Amanap  lana c  anal Panama
        System.out.println(isPalindrome(">@#"));
    }

    public static boolean isPalindrome(String s) {
        s = s.toLowerCase();
        char[] chars = s.toCharArray();

        //左索引
        int l = 0;
        //右索引
        int r = chars.length - 1;

        while (l < r) {

            //判断左节点是否为字符，如果不是则右移
            while (l < chars.length && !isValidChar(chars[l]) ) {
                l++;
            }
            //判断右节点是否为字符，如果不是则左移
            while (r >= 0 && !isValidChar(chars[r])) {
                r--;
            }
            //如果左右下标的字符串不相等，则返回false
            if (l < chars.length && r >= 0 && chars[l] != chars[r]) {
                return false;
            }
            //如果相等，则进行下一个字符的比较
            l++;
            r--;
        }
        return true;
    }

    //判断字符是否是英文字母或者数字
    private static boolean isValidChar(char c) {
        return (c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z') || (c >= '0' && c <= '9');
    }

}
