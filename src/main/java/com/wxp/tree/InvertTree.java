package com.wxp.tree;

/**
 * 226. 翻转二叉树
 * Created by 10521 on 2018/10/28.
 */
public class InvertTree {
    public TreeNode invertTree(TreeNode root) {
        if(root == null){
            return null;
        }
        convert(root);
        return root;
    }

    private void convert(TreeNode root) {
        if(root == null){
            return;
        }
        convert(root.left);
        convert(root.right);
        TreeNode tmp = root.left;
        root.left = root.right;
        root.right = tmp;
    }
}
