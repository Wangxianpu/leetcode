package com.wxp.tree;

/**
 * Created by 10521 on 2018/9/20.
 */
public class SumOfLeftLeaves {

    public int result = 0;

    public int sumOfLeftLeaves(TreeNode root) {
        if(root == null) return 0;
        return getSum(root,2);
    }

    private int getSum(TreeNode root, int flag) {
        if(root == null){
            return 0;
        }
        if(flag == 0 && root.right == null && root.left == null){
            result += root.val;
        }
        getSum(root.left,0);
        getSum(root.right,1);
        return result;
    }
}
