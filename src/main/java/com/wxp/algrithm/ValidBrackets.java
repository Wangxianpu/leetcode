package com.wxp.algrithm;

import java.util.Stack;

/**
 * @description:
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。
 *
 * 有效字符串需满足：
 *      左括号必须用相同类型的右括号闭合。
 *      左括号必须以正确的顺序闭合。
 *
 * @author: wxp
 * @time: 2022/4/3 14:26
 */
public class ValidBrackets {

    public static void main(String[] args) {
        String str = "()[]{}";
        System.out.println(isValid(str));
    }

    public static boolean isValid(String s) {
        if (s == null || s.length() == 0){
            return true;
        }
        char[] arr = s.toCharArray();

        Stack stack = new Stack();

        for (char c : arr) {

            if(stack.empty()){
                stack.push(c);
                continue;
            }
            if(c == '(' || c == '[' || c == '{'){
                stack.push(c);
                continue;
            }
            if (c == ')' || c == ']' || c == '}'){
                if(stack.isEmpty()){
                    return false;
                }
                char comp = (char) stack.pop();
                if((c == ')' && comp == '(') || (c == ']' && comp == '[')
                    || (c == '}' && comp == '{')){
                }else {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
}
