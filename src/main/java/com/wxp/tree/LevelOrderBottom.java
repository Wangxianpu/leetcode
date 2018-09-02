package com.wxp.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by 10521 on 2018/9/2.
 */
public class LevelOrderBottom {
    List<List<Integer>> result = new ArrayList<List<Integer>>();
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
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
        List<List<Integer>> returnRes = new ArrayList<List<Integer>>();
        for(int i = result.size() - 1 ; i >= 0 ; i--){
            returnRes.add(result.get(i));
        }
        return returnRes;
    }
}
