package com.wxp.tree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * 897. 递增顺序查找树
 * Created by 10521 on 2018/10/27.
 */
public class IncreasingBST {
    List<Integer> list ;
    public TreeNode increasingBST(TreeNode root) {
        if(root == null){
            return null;
        }
        list = new ArrayList<Integer>();
        traverse(root);
        Collections.sort(list);
        return dfs(list,0);
    }

    private TreeNode dfs(List<Integer> list,int cursor) {

        TreeNode tree = new TreeNode(list.get(cursor));
        if(cursor >= list.size()-1){
            return tree;
        }else{
            tree.right = dfs(list,cursor+1);
        }
        return tree;
    }

    private void traverse(TreeNode root) {
        if(root == null){
            return;
        }
        traverse(root.left);
        list.add(root.val);
        traverse(root.right);
    }

    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(6,3,2,7,9,5);
        Collections.sort(list);
        System.out.println(list);
    }
}
