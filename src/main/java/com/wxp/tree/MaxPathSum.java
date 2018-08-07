package com.wxp.tree;

/**
 * @Author : shampoowang
 * @Date:Created : 2018/6/25 19:57
 * @Description : 二叉树中的最大路径和
 */
public class MaxPathSum {
    //记录最后答案
    int ans ;

    public int maxDeep(TreeNode node){
        if(node == null){
            return 0;
        }
        if(node.left == null && node.right == null){
            ans = Math.max(ans,node.val);
            return node.val;
        }else{
            int maxRight = maxDeep(node.right);
            int maxLeft = maxDeep(node.left);
            int temp = maxLeft + maxRight + node.val;

            temp = Math.max(temp,node.val);

            ans = Math.max(temp ,ans);
            return temp;
        }
    }

    public int maxPathSum(TreeNode root) {
        return maxDeep(root);
    }

}


// Definition for a binary tree node.
 class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;
     TreeNode(int x) { val = x; }
 }
