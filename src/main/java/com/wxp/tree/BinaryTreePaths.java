package com.wxp.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * 257. 二叉树的所有路径
 * Created by wangxianpu on 2018/10/22.
 */
public class BinaryTreePaths {

    List<String> ans ;

    public List<String> binaryTreePaths(TreeNode root) {
        ans = new ArrayList<String>();
        if(root == null ){
            return ans;
        }
        if(root.left != null)
        dfs(root.left,String.valueOf(root.val));
        if(root.right != null)
        dfs(root.right,String.valueOf(root.val));
        if(root.left == null && root.right == null)
        ans.add(String.valueOf(root.val));
        return ans;
    }

    private void dfs(TreeNode root,String route) {
        route += "->"+String.valueOf(root.val);
        if(root.left == null && root.right == null){
            ans.add(route);
            return;
        }
        if(root.left != null)
        dfs(root.left,route);
        if(root.right != null)
        dfs(root.right,route);
    }
}
