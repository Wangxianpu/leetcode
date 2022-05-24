package com.wxp.algrithm.normalQuestion;

import com.wxp.common.TreeNode;

/**
 * @description: 单值二叉树
 * @author: wxp
 * @time: 2022/5/24 20:41
 */
public class IsUnivalTree_965 {


    public static boolean isUnivalTree(TreeNode root) {
        return uniTree(root,root.val);
    }

    private static boolean uniTree(TreeNode root, int val) {
        if(root == null){
            return true;
        }
        if(root.val != val){
            return false;
        }
        return uniTree(root.left,val) &&  uniTree(root.right,val);
    }
//[9,9,6,9,9]
    public static void main(String[] args) {
        TreeNode root = new TreeNode(9);
        root.left = new TreeNode(9);
        root.right = new TreeNode(6);
        root.left.left = new TreeNode(9);
        root.left.right = new TreeNode(9);
        System.out.println(isUnivalTree(root));
    }

}
