package com.wxp.tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by 10521 on 2018/9/2.
 * 111. 二叉树的最小深度
 */
public class MinDepth {
    public int minDepth(TreeNode root) {
        int result = 0;
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        if(root == null){
            return result;
        }
        queue.offer(root);
        while(!queue.isEmpty()){
            int size = queue.size();
            result++;
            while(size-- > 0){
                TreeNode node = queue.poll();

                if(node.left == null && node.right == null){
                    return result;
                }
                if(node.left != null ) queue.offer(node.left);
                if(node.right != null) queue.offer(node.right);
            }
        }
        return result;
    }
}
