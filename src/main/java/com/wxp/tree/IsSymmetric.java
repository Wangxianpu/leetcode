package com.wxp.tree;

/**
 * Created by 10521 on 2018/8/25.
 */
public class IsSymmetric {
    public boolean isSymmetric(TreeNode root) {
        if(root == null || (root.left == null && root.right == null) ){
            return true;
        }
        if(root.right != null && root.left !=null){
           return isSame(root.right,root.left);
        }
        return false;
    }

    private boolean isSame(TreeNode right, TreeNode left) {
        if(right == null && left == null){
            return true;
        }
        if(right != null && left != null && right.val == left.val){
            return isSame(right.right,left.left) && isSame(right.left,left.right);
        }
        return false;
    }
}
