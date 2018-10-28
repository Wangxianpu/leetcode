package com.wxp.tree;

/**
 * 617. 合并二叉树
 * Created by 10521 on 2018/10/28.
 */
public class MergeTrees {
    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        TreeNode root;
        TreeNode left_1 = null, left_2 = null;
        TreeNode right_1 = null, right_2 = null;

        if(t1 == null && t2 == null)
            return null;
        else if(t1 != null && t2 != null)
        {
            root = new TreeNode(t1.val + t2.val);
            left_1 = t1.left;
            left_2 = t2.left;
            right_1 = t1.right;
            right_2 = t2.right;
        }
        else if(t1 != null && t2 == null)
        {
            root = new TreeNode(t1.val);
            left_1 = t1.left;
            right_1 = t1.right;
        }
        else
        {
            root = new TreeNode(t2.val);
            left_2 = t2.left;
            right_2 = t2.right;
        }


        root.left = mergeTrees(left_1, left_2);
        root.right = mergeTrees(right_1, right_2);

        return root;
    }

    public TreeNode mergeTrees2(TreeNode t1, TreeNode t2) {
        if (t1 == null && t2 == null)
            return null;
        if (t1 == null)
            return t2;
        if (t2 == null)
            return t1;

        t1.val = t1.val + t2.val;

        t1.left = mergeTrees(t1.left, t2.left);
        t1.right = mergeTrees(t1.right, t2.right);

        return t1;
    }
}
