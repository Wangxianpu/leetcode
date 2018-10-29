package com.wxp.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * 637. 二叉树的层平均值
 * Created by 10521 on 2018/10/29.
 */
public class AverageOfLevels {
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> ans = new ArrayList<Double>();
        List<List<Integer>> levelList = new ArrayList<List<Integer>>();
        if(root == null){
            return ans;
        }
        fillAns(root , 0 ,levelList);

        for(List<Integer> tmpList : levelList){
            long sum = 0;
            for(Integer i : tmpList){
                sum +=i;
            }
            ans.add((sum/(double)tmpList.size()));
        }
        return ans;
    }

    private void fillAns(TreeNode root, int level, List<List<Integer>> levelList) {
        if(root == null ) return;
        if(levelList.size() < level + 1){
            levelList.add(new ArrayList<Integer>());
        }
        levelList.get(level).add(root.val);
        level += 1;
        fillAns(root.left,level,levelList);
        fillAns(root.right,level,levelList);
    }
}
