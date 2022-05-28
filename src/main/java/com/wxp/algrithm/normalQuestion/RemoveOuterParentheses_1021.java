package com.wxp.algrithm.normalQuestion;


/**
 * @description: 删除最外层的括号
 * @author: wxp
 * @time: 2022/5/28 10:18
 */
public class RemoveOuterParentheses_1021 {
    public static void main(String[] args) {
        String str = "(()())(())(()(()))";
        String res = new RemoveOuterParentheses_1021().removeOuterParentheses(str);
        assert "()()()()(())".equals(res);
        System.out.println(res);
    }

    public String removeOuterParentheses(String s) {
        if(s == null || s.length() == 0 ){
            return "";
        }
        int cursor = 0;
        StringBuilder sb = new StringBuilder();
        for (char c : s.toCharArray() ) {
            if(c == ')'){
                cursor--;
            }
            if(cursor > 0){
                sb.append(c);
            }
            if(c == '('){
                cursor++;
            }

        }
        return sb.toString();
    }
}
