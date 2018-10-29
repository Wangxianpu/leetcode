package com.wxp.tree;


/**
 * 700. 二叉搜索树中的搜索
 * Created by 10521 on 2018/10/29.
 */
public class SearchInBST {

    public TreeNode searchBST(TreeNode root, int val) {
        if(root == null) return null;
        if(val == root.val) return root;
        if(val < root.val) return searchBST(root.left,val);
        return searchBST(root.right,val);
    }
}
