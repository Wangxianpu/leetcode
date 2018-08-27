package com.wxp.tree;

/**
 * Created by 10521 on 2018/8/25.
 * 100. 相同的树
 */


public class IsSameTree {
    public boolean isSameTree(TreeNode p ,TreeNode q ){

        if(p == null && q == null){
            return true;
        }
        if(p!=null && q!=null && q.val == p.val){
            return isSameTree(p.left,q.left) && isSameTree(p.right,q.right);
        }
        return false;
    }
}
