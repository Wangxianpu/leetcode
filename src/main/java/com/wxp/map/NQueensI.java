package com.wxp.map;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 10521 on 2018/9/5.
 * 51. N皇后
 */
public class NQueensI {
    List<List<String>> ans = new ArrayList<List<String>>();

    int[] row;

    boolean[] line;

    boolean[] slash;

    boolean[] backlash;

    /**
     * 对列进行深度优先搜索
     * @param idx
     * @param n
     */
    void dfs(int idx,int n){
        //结束条件   记录结果
        if(idx >= n){
            List<String> tmp = new ArrayList<String>();
            for(int i = 0 ; i < n ; i++){
                String str = "";
                for(int j = 0 ; j < n ; j++){
                    if(row[i] == j){
                        str +="Q";
                    }else{
                        str +=".";
                    }
                }
                tmp.add(str);
            }
            ans.add(tmp);
            return ;
        }

        for(int i = 0 ; i < n ; i++){
            if(!line[i] && !slash[idx + i] && !backlash[idx-i+n-1]){
                row[idx] = i;
                line[i] = true;
                slash[i+idx] = true;
                backlash[idx-i+n-1] = true;
                dfs(idx + 1 , n);
                line[i] = false;  // 还原现场
                slash[i+idx] = false;
                backlash[idx-i+n-1] = false;
            }
        }
    }

    public List<List<String>> solveNQueens(int n) {
        row = new int[n];
        line = new boolean[n];
        slash = new boolean[2*n];
        backlash = new boolean[2*n];
        dfs(0,n);
        return ans;
    }

    public static void main(String[] args) {
        new NQueensI().solveNQueens(4);
    }
}
