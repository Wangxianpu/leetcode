package com.wxp.recursion;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 10521 on 2018/9/3.
 * 78. 子集
 */
public class Subsets {

    List<List<Integer>> ans = new ArrayList<List<Integer>>();

    boolean[] flag ;

    public List<List<Integer>> subsets(int[] nums) {
        flag = new boolean[nums.length];
        getSubSets(0,nums);
        return ans;
    }

    private void getSubSets(int index, int[] nums) {
        if(index >= nums.length){
            List<Integer> r = new ArrayList<Integer>();
            for(int i = 0; i < nums.length ; i++){
                if(flag[i]){
                    r.add(nums[i]);
                }
            }
            ans.add(r);
            return;
        }
        flag[index] = true;
        getSubSets(index + 1,nums);
        flag[index] = false;
        getSubSets(index + 1,nums);
    }
}
