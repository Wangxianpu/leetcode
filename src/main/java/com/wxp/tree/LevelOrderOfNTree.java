package com.wxp.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 429. N叉树的层序遍历
 * Created by 10521 on 2018/10/29.
 */
public class LevelOrderOfNTree {
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        if(root == null){
            return ans;
        }
        List<Node> queue = new ArrayList<Node>();
        queue.add(root);
        while(queue.size() > 0){
            List<Integer> list = new ArrayList<Integer>();
            for(Node n : queue){
                list.add(n.val);
            }
            ans.add(list);
            List<Node> tmpList = new ArrayList<Node>();
            for(Node tmpNode : queue){
                for(Node childNode : tmpNode.children){
                    tmpList.add(childNode);
                }
            }
            queue = tmpList;
        }
        return ans;
    }

    //别人的方法，就是厉害 以level来分割，这样就只需要进行遍历一遍就可以了
    public List<List<Integer>> levelOrder2(Node root) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if(root == null)
            return res;
        fillRes(root, 0, res);

        return res;
    }

    public void fillRes(Node root, int level, List<List<Integer>> res) {
        if(res.size() < level + 1)
            res.add(new ArrayList<Integer>());

        res.get(level).add(root.val);

        for (Node n : root.children) {
            fillRes(n, level + 1, res);
        }
    }
}
