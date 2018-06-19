package com.wxp.sort;

/**
 * @Author : shampoowang
 * @Date:Created : 2018/6/19 11:27
 * @Description :
 */
public class SplitMaxArray {

    public static void main(String[] args) {
        System.out.println(new SplitMaxArray().splitArray(new int[]{1,2147483646},2));
    }

    public int splitArray(int[] nums, int m) {
        long L = 0,R = 1;
        for(int i=0 ;i<nums.length;i++){
            R+=nums[i];//m>=1
        }
        long  ans = 0;
        while(L < R){
            //对于给定的m，寻找出对应的mid，满足mid最小
            long mid = (L+R)/2;
            if(guess(nums,m,mid)){
                R = mid;
                ans = mid;
            }else{
                L = mid+1;
            }
        }
        return (int)ans;
    }

    //判断m分割，能否满足每个分割数组 最大值小于mid的情况  贪心处理
    private boolean guess(int[] nums, int m, long mid) {
        long sum = 0;
        for(int i = 0 ; i < nums.length ; ++i){
            //如果超出mid，则该分割数组最大值超过，划分下一个数组
            if(sum + nums[i] > mid){
                m--;
                sum = nums[i];
                if(nums[i] > mid){
                    return false;
                }
            }else{
                sum += nums[i];
            }
        }
        return m>=1;
    }
}
