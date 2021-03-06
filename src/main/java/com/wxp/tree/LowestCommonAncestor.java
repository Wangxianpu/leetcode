package com.wxp.tree;

/**
 * 235. 二叉搜索树的最近公共祖先
 * Created by 10521 on 2018/10/29.
 */
public class LowestCommonAncestor {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null){
            return null;
        }
        if(root.val > p.val && root.val > q.val){
            return lowestCommonAncestor(root.left,p,q);
        }else if (root.val < p.val && root.val < q.val){
            return lowestCommonAncestor(root.right,p,q);
        }else{
            return root;
        }
    }
}
