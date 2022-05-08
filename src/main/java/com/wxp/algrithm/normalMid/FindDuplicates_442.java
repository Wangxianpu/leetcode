package com.wxp.algrithm.normalMid;

import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

/**
 * @description:  442、数组中重复的数据
 *  给你一个长度为 n 的整数数组 nums ，其中 nums 的所有整数都在范围 [1, n] 内，
 *  且每个整数出现 一次 或 两次 。请你找出所有出现 两次 的整数，并以数组形式返回。
 *

 * 你必须设计并实现一个时间复杂度为 O(n) 且仅使用常量 额外空间的算法解决此问题。
 *
 * 因为元素的取值范围在1-n之间，所以可以直接对值进行索引遍历，也不用管数组中的具体值。
 * 当遍历到的时候直接给其增加n，如果在遍历的过程遇到值大于n的数据，%n即可。
 *
 * @author: wxp
 * @time: 2022/5/8 7:46
 */
public class FindDuplicates_442 {

    public static void main(String[] args) {
        int[] nums = new int[]{1};

        System.out.println(new Gson().toJson(findDuplicates(nums)));
    }

    private static List<Integer>  findDuplicates(int[] nums) {
        List<Integer> res = new ArrayList<>();
        int len = nums.length;
        //通过数组的值对数据进行遍历，如果遍历到则对其值+n
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            int index = (num-1) % len;
            nums[index] = nums[index] + len;
        }

        for (int i = 0; i < len; i++) {
            if(nums[i] > 2*len){
                res.add(i+1);
            }
        }
        return res;
    }

    public static List<Integer> findDuplicates2(int[] nums) {
        List<Integer> res = new ArrayList<>();
        if(null == nums || nums.length == 0){
            return res;
        }
        int salt = nums[0];
        for (int i = 1; i < nums.length; i++) {
            int tmp = salt;
            salt = salt ^ nums[i];
            if(salt == 0){
                res.add(nums[i]);
                salt = tmp;
            }
        }
        return res;
    }
}
