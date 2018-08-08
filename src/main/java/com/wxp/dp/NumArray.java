package com.wxp.dp;

/**
 * @Author : shampoowang
 * @Date:Created : 2018/8/8 10:20
 * @Description :
 */
public class NumArray {

    int[] obj;

    public NumArray(int[] nums) {
        this.obj = nums;
    }

    public int sumRange(int i, int j) {
        if(i<0 || j >= obj.length ){
            return 0;
        }
        int sum = 0;
        for(; i <= j ; i++){
            sum += obj[i];
        }
        return sum;
    }
}