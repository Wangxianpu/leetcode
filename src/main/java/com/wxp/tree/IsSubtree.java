package com.wxp.tree;

/**
 * Created by 10521 on 2018/9/20.
 */
public class IsSubtree {
    public boolean isSubtree(TreeNode s, TreeNode t) {
        if(s == null && t != null ){
            return false;
        }
        if(isSame(s,t)){
            return true;
        }
        return isSubtree(s.left,t) || isSubtree(s.right,t);
    }

    private boolean isSame(TreeNode s, TreeNode t) {
        if(s == null && t == null){
            return true;
        }
        if(s == null || t == null){
            return false;
        }
        //如果不相等则返回false，
        // 如果相等返回true的话，那么就不会出现false的情况了，也就无法判断比较这两个是否相等
        if(s.val != t.val){
            return false;
        }
        return isSame(s.right, t.right) && isSame(s.left,t.left);
    }
}
