package com.wxp.tree;

import java.util.Arrays;

/**
 * Created by 10521 on 2018/8/25.
 * 105. 从前序与中序遍历序列构造二叉树
 * 如 :
 * 前序遍历 preorder = [3,9,20,15,7]
 * 中序遍历 inorder = [9,3,15,20,7]
 */
public class BuildTree {
    int[] pre;
    int[] in;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        pre = preorder;
        in = inorder;
        TreeNode tree = buildChild(0,preorder.length-1,0,inorder.length-1);
        return tree;
    }


    private TreeNode buildChild(int st1, int ed1, int st2, int ed2) {
        if(st1 > ed1){
            return null;
        }
        TreeNode tree = new TreeNode(pre[st1]);
        int find = -1;
        for(int i = st2 ; i <= ed2 ; i++){
            if(pre[st1] == in[i]){
                find = i;
                break;
            }
        }
        if(find == -1 ){
            return null;
        }
        tree.left = buildChild(st1+1,st1 + (find -st2),st2 , find-1);
        tree.right = buildChild(st1 + (find -st2)+1,ed1,find+1,ed2);
        return tree;
    }

}
