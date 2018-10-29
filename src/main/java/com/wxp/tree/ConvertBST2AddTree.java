package com.wxp.tree;

/**
 * 538. 把二叉搜索树转换为累加树
 * Created by 10521 on 2018/10/29.
 */
public class ConvertBST2AddTree {
    public TreeNode convertBST2(TreeNode root) {
        if(root == null){
            return null;
        }
        convertBST(root.right);
        convertBST(root.left);
        if(root.right != null){
            root.val = root.val + root.right.val;
        }
        if(root.left != null){
            root.left.val = root.val + root.left.val;
        }
        return root;
    }


    // 先将右子树转换为累加树；并记录右子树的累加和rightSum;
    // 然后处理根节点，根节点的值 = 根节点值 + rightSum;
    // 然后转化左子树
    public TreeNode convertBST(TreeNode root) {
        convert(root, 0);
        return root;
    }

    public int convert(TreeNode root, int rightSum){
        if(null == root){
            return rightSum;
        }
        rightSum = convert(root.right, rightSum);
        root.val = root.val + rightSum;
        rightSum = root.val;
        rightSum = convert(root.left, rightSum);
        return rightSum;
    }


}
