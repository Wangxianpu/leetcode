package com.wxp.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 10521 on 2018/8/27.
 * 94. 二叉树的中序遍历
 */
public class InorderTraversal {

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<Integer>();
        if(root == null) return result;
        return build(root,result);
    }

    private List<Integer> build(TreeNode root,List<Integer> result) {
        if(root == null){
            return null;
        }
        build(root.left,result);
        result.add(root.val);
        build(root.right,result);
        return result;
    }
}
