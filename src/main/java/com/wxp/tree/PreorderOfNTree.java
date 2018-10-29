package com.wxp.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * 589. N叉树的前序遍历
 * Created by 10521 on 2018/10/29.
 */
public class PreorderOfNTree {
    List<Integer> ans;
    public List<Integer> preorder(Node root) {
        ans = new ArrayList<Integer>();
        if(root == null){
            return ans;
        }
        pre(root);
        return ans;
    }

    private void pre(Node root) {
        if(root == null){
            return;
        }
        ans.add(root.val);
        for(Node n : root.children){
            pre(n);
        }
    }
}
