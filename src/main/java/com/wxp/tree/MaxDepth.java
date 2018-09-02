package com.wxp.tree;

/**
 * Created by 10521 on 2018/9/2.
 */
public class MaxDepth {
    int depth ;
    public int maxDepth(TreeNode root) {
        if(root == null){
            return 0;
        }
        return deep(1,root);
    }

    private int deep(int deep, TreeNode root) {
        if(root == null){
            return depth;
        }
        if(deep > depth){
            depth = deep;
        }
        deep(deep+1,root.left);
        deep(deep+1,root.right);
        return depth;
    }
}
