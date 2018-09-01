package com.wxp.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 10521 on 2018/9/1.
 * 98. 验证二叉搜索树
 */
public class IsValidBST {

    List<Integer> list = new ArrayList<Integer>();

    public boolean isValidBST(TreeNode root) {
        if(root == null || (root.left == null && root.right == null)){
            return true;
        }
        traversal(root);
        int temp = list.get(0);
        for(int i = 1 ; i < list.size() ; i++){
            if(list.get(i) == null){
                continue;
            }
            if(list.get(i-1) == null){
                if(list.get(i) > temp ){
                    continue;
                }
                return false;
            }
            temp = list.get(i);
            if(list.get(i) > list.get(i-1)){
                continue;
            }else{
                return false;
            }
        }
        return true;
    }

    private void traversal(TreeNode root) {
        if(root == null) return ;
        traversal(root.left);
        list.add(root.val);
        traversal(root.right);
    }
}
