package com.wxp.tree;

/**
 * 872. 叶子相似的树
 * Created by wangxianpu on 2018/10/26.
 */
public class LeafSimilarTree {
    String tmp = "";
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        if(root1 == null || root2 == null){
            return false;
        }
        String str1 = leaf(root1,tmp);
        tmp = "";
        String str2 = leaf(root2,tmp);
        return str1.equals(str2);
    }

    private String leaf(TreeNode root, String str) {
        if(root == null){
            return tmp;
        }
        if(root.left == null && root.right == null){
            tmp = str + root.val;
            return tmp;
        }
        leaf(root.left,tmp);
        leaf(root.right,tmp);
        return tmp;
    }
}
