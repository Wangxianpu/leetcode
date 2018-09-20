package com.wxp.tree;

import java.util.List;

/**
 * Created by 10521 on 2018/9/20.
 */
public class PathSumIII {

    public int result = 0;

    public int pathSum(TreeNode root, int sum) {
        if(root == null){
            return 0;
        }
        return findPath(root,sum) + pathSum(root.left,sum ) + pathSum(root.right , sum );
    }

    private int findPath(TreeNode root, int sum) {
        if(root == null){
            return 0 ;
        }
        if(sum == root.val){
            return 1 + findPath(root.left , 0) + findPath(root.right , 0);
        }

        return findPath(root.left , sum - root.val) + findPath(root.right , sum - root.val);
    }
}
