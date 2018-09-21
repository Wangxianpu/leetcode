package com.wxp.tree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by 10521 on 2018/9/21.
 */
public class FindMode {

    private Map<Integer,Integer> map = new HashMap<Integer,Integer>();
    private int max = 1 ;

    public int[] findMode(TreeNode root) {
        if(root == null ){
            return new int[0];
        }
        getMode(root);
        List<Integer> res = new ArrayList<Integer>();
        for(Integer tmp : map.keySet()){
            if(map.get(tmp) == max){
                res.add(tmp);
            }
        }
        int[] ans = new int[res.size()];

        for(int i = 0 ; i < res.size() ; i++){
            ans[i] = res.get(i);
        }
        return ans;
    }

    private void getMode(TreeNode root) {
        if(root == null){
            return;
        }
        if(map.containsKey(root.val)){
            map.put(root.val,map.get(root.val) + 1);
            if(map.get(root.val) > max){
                max = map.get(root.val);
            }
        }else{
            map.put(root.val,1);
        }
        getMode(root.left);
        getMode(root.right);
    }

}
