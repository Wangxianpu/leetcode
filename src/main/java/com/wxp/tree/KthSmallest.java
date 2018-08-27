package com.wxp.tree;

/**
 * Created by 10521 on 2018/8/25.
 * 230. 二叉搜索树中第K小的元素
 */
public class KthSmallest {
    private static int result;
    private static int c = 0;

    public static int kthSmallest(TreeNode root, int k) {
        count(root,k);
        return result;
    }

    private static void count(TreeNode root, int k) {
        if(root == null){
            return;
        }
        if(root.left != null){
            count(root.left, k );
        }
        c++;
        if(k - c == 0){
            result = root.val;
        }else{
            if(root.right != null){
                count(root.right,k);
            }
        }
    }


    public static void main(String[] args) {
        TreeNode tree = new TreeNode(5);
        tree.left = new TreeNode(3);
        tree.right = new TreeNode(6);
        tree.left.left = new TreeNode(2);
        tree.left.right = new TreeNode(4);
        tree.left.left.left = new TreeNode(1);

        kthSmallest(tree,5);
    }

}


