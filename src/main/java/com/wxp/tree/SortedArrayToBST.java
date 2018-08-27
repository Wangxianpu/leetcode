package com.wxp.tree;

/**
 * Created by 10521 on 2018/8/27.
 * 108. 将有序数组转换为二叉搜索树
 */
public class SortedArrayToBST {
    int[] array ;
    public TreeNode sortedArrayToBST(int[] nums) {
        array = nums;
        return buildBST(0,nums.length-1);
    }

    private TreeNode buildBST(int start, int end) {
        if(start > end){
            return null;
        }
        int mid = (start + end)/2;
        TreeNode tree = new TreeNode(array[mid]);
        tree.left = buildBST(start,mid - 1);
        tree.right = buildBST(mid+1,end);
        return tree;
    }
}
