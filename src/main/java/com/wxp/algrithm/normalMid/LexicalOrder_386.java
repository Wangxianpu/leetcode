package com.wxp.algrithm.normalMid;

import com.wxp.common.ConstantsTest;

import java.util.ArrayList;
import java.util.List;

/**
 * @description: 字典序排列
 * @author: wxp
 * @time: 2022/4/18 21:51
 */
public class LexicalOrder_386 {

    public static void main(String[] args) {
        System.out.println(ConstantsTest.GSON.toJson(lexicalOrder(13)));
    }

    static  List<Integer> res = new ArrayList<>();
    /**
     * 解法，使用十叉树
     */
    public static List<Integer> lexicalOrder(int n) {
        for (int i = 1; i < 10; i++) {
            dfs(i,n);
        }
        return res;
    }

    private static void dfs(int cur, int n) {
        if(cur  > n){
          return;
        }
        res.add(cur);
        for (int i = 0; i <= 9; i++) {
            dfs(cur*10 + i,n);
        }
    }

}
