package com.wxp.tree;

/**
 * Created by 10521 on 2018/8/27.
 * 110. 平衡二叉树
 */
public class IsBalanced {
    public boolean isBalanced(TreeNode root) {
        if(root == null ){
            return true;
        }
        int leftDeep = depth(root.left);
        int rightDeep = depth(root.right);
        if(Math.abs(leftDeep - rightDeep) > 1){
            return false;
        }else{
            return  isBalanced(root.left)&&isBalanced(root.right);
        }
    }

    /**
     * 当前节点的深度
     * @param root
     * @return
     */
    private int depth(TreeNode root) {
        if(root == null){
            return 0;
        }
        return Math.max(depth(root.right),depth(root.left)) + 1;
    }


}
/**
 * 构件二叉树
 */
class BuildTreeByString {
    Integer[] nums = new Integer[]{1,2,2,3,null,null,3,4,null,null,4};
    TreeNode tree ;


}
