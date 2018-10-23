package com.wxp.tree;

import java.util.List;

/**
 * 559. N叉树的最大深度
 * Created by wangxianpu on 2018/10/23.
 */
public class MaxDepthOfNTree {
    
    int max = 0;
    
    public int maxDepth(Node root) {
        if(root == null)
            return max;
        dfs(root,1);
        return max;
    }

    private void dfs(Node root,int deep) {
        if(root.children == null || root.children.size() == 0){
            if(deep > max){
                max = deep;
            }
            return;
        }
        deep++;
        for(Node node : root.children){
            dfs(node,deep);
        }
    }
}

class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val,List<Node> _children) {
        val = _val;
        children = _children;
    }
};