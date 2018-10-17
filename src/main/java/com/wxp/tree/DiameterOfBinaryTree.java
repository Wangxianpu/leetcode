package com.wxp.tree;

/**
 *  543、二叉树的直径
 * Created by wangxianpu on 2018/10/16.
 *  计算二叉树的高度的时候比较左右节点的深度，那么就可以找到最深的子节点了
 */
public class DiameterOfBinaryTree {

    int ans = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        if(root == null ||(root.left == null && root.right == null )){
            return 0;
        }
        getDiameter(root);
        return ans;
    }

    private int getDiameter(TreeNode root) {
        if(root == null){
            return 0;
        }
        int left = getDiameter(root.left);
        int right = getDiameter(root.right);
        //表示当前的节点的最大宽度
        if((left + right) > ans ){
            ans = left + right;
        }
        return left > right ? left+1 : right + 1;
    }


}
