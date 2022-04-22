package com.wxp.algrithm.array;

/**
 * @description:
 * @author: wxp
 * @time: 2022/4/3 20:11
 */
public class DeleteRepeatArray_26 {

    public static void main(String[] args) {
        int[] nums = new int[]{0,0,1,1,1,2,2,3,3,4};
        System.out.println(removeDuplicates(nums));
    }

    public static int removeDuplicates(int[] nums) {
        if(nums == null || nums.length == 0 ){
            return 0;
        }
        //游标，
        int cursor = nums[0];
        int deleteNum = 0;
        for (int i = 1; i < nums.length; i++) {
            if(cursor != nums[i]){
                cursor = nums[i];
                nums[i-deleteNum] = nums[i];
                continue;
            }
            deleteNum++;
        }
        return nums.length - deleteNum;
    }
}
