package com.wxp.tree;

/**
 * 669. 修剪二叉搜索树
 * Created by 10521 on 2018/10/29.
 * 思路过程：这题并不难，但是关键点在于细节化，可以说我为什么写了三个版本才写出来，
 * 原因就是在于，对真个运行过程的不清晰，如果将宏观的步骤写弄出来比如：
 *  1、二叉树搜索分左子树搜索和右子树搜索
 *  2、什么时候搜索左子树，什么时候所搜右子树
 *  3、除了两种情况，一是值比右子树还大，而是比左子树还小，其他的都可以保持树的不变，即不做任何操作，直接返回原值
 */
public class TrimBST {
    public TreeNode trimBST2(TreeNode root, int L, int R) {
        if(root == null) return null;
        if(root.left != null ){
            //如果左子树值大于允许最小值，则继续往左
            if(root.left.val >= L){
               root = trimBST(root.left,L,R);
            }else{
                root.left = root.left.right;
            }
        } else{
            //如果右子树值小于允许最大值，则继续往右
            if(root.right.val <= R){
                root = trimBST(root.right,L,R);
            }else{
                root.right = root.right.left;
            }
        }
        return root;
    }

    public TreeNode trimBST3(TreeNode root, int L, int R) {
        if(root == null) return null;
        if(root.val <= R ) root = trimBST(root.right,L,R);
        else root = root.left;
        if(root != null){
            if(root.val >= L) root = trimBST(root.left,L,R);
            else root = root.right;
        }
        return root;
    }

    //bingo 这个才是正确的解法
    public TreeNode trimBST(TreeNode root, int L, int R) {
        if(root == null){
            return null;
        }
        if(root.val > R){
            return trimBST(root.left,L,R);
        }
        else if(root.val < L){
            return trimBST(root.right,L,R);
        }else{
            root.left = trimBST(root.left,L,R);
            root.right = trimBST(root.right,L,R);
        }
        return root;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(0);
        root.right = new TreeNode(2);
        TreeNode node = new TrimBST().trimBST(root,1,2);

    }
}
