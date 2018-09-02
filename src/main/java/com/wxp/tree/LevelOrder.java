package com.wxp.tree;

import sun.reflect.generics.tree.Tree;

import java.util.*;

/**
 * Created by 10521 on 2018/8/25.
 */
public class LevelOrder {
    static List<List<Integer>> result = new ArrayList<List<Integer>>();
    public static List<List<Integer>> levelOrder(TreeNode root) {
        if(root == null){
            return result;
        }
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        while (!queue.isEmpty()){
            List<Integer> tempList = new ArrayList<Integer>();
            int size = queue.size();
            while(size-- > 0){
                TreeNode node = queue.poll();
                tempList.add(node.val);
                if(node.left != null)
                queue.offer(node.left);
                if(node.right != null)
                queue.offer(node.right);
            }
            result.add(tempList);
        }
        return result;
    }

    public static void main(String[] args) {
        TreeNode tree = new TreeNode(3);
        tree.left = new TreeNode(9);
        tree.right = new TreeNode(20);
        tree.right.left = new TreeNode(15);
        tree.right.right = new TreeNode(7);

        levelOrder(tree);
    }
}
