package com.wxp.algrithm.array;

/**
 * @description: 
 * @author: wxp
 * @time: 2022/4/3 23:34
 */
public class RemoveElement_27 {

    public static void main(String[] args) {
        int[] nums = new int[]{0,0,1,1,1,2,2,3,3,4};
        System.out.println(removeElement(nums,2));
    }

    public static int removeElement(int[] nums, int val) {
        if(nums == null || nums.length == 0 ){
            return 0;
        }
        //记录删除的数量
        int deleteCnt = 0;
        for (int i = 0; i < nums.length; i++) {
            if(nums[i] == val){
                deleteCnt++;
            }else{
                nums[i-deleteCnt] = nums[i];
            }
        }
        return nums.length - deleteCnt;
    }
}
