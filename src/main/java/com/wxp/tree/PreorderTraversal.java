package com.wxp.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 10521 on 2018/8/25.
 * 144. 二叉树的前序遍历
 */
public class PreorderTraversal {

    List<Integer> result = new ArrayList<Integer>();
    public List<Integer> preorderTraversal(TreeNode root) {
        if(root != null ) {
            result.add(root.val);
            preorderTraversal(root.left);
            preorderTraversal(root.right);
        }
        return result;
    }
}
