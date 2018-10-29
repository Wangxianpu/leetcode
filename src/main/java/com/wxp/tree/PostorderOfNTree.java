package com.wxp.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * 590. N叉树的后序遍历
 * Created by 10521 on 2018/10/29.
 */
public class PostorderOfNTree {
    List<Integer> ans;
    public List<Integer> postorder(Node root) {
        ans = new ArrayList<Integer>();
        if(root == null){
            return ans;
        }
        post(root);
        return ans;
    }

    private void post(Node root) {
        if(root == null){
            return;
        }
        for(Node n : root.children){
            post(n);
        }
        ans.add(root.val);
    }
}
