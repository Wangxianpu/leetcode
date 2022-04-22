package com.wxp.Array;

/**
 * @description: 旋转的函数(顺时针旋转)
 *
 *  把数组逆转跟把乘数逆转是一样的，可以看出有如下规律
 *    4     3     2     6
 *
 *   0*4   1*3   2*2   3*6   F(0)
 *
 *   3*4   0*3   1*2   2*6   F(1) = F(0) - SUM(data) + N * data[0];
 *
 *   2*4   3*3   0*2   1*6   F(2) = F(1) - SUM(data) + N * data[1];
 *
 *   1*4   2*3   3*2   0*6   F(3) = F(2) - SUM(data) + N * data[2];
 *
 * @author: wxp
 * @time: 2022/4/22 20:39
 */
public class MaxRotateFunction_396 {
    public static void main(String[] args) {
        int[] nums = new int[]{4,3,2,6};
//        int[] nums = new int[]{100};
        System.out.println(maxRotateFunction(nums));
    }

    private static int maxRotateFunction(int[] nums) {
        if(null == nums || nums.length == 0){
            return 0;
        }
        int maxFun = 0;
        int sum = 0;
        for(int i = 0 ; i < nums.length ; i++){
            maxFun += i*nums[i];
            sum += nums[i];
        }
        int tmpFun = maxFun;
        for(int i = 1 ; i < nums.length ; i++){
            tmpFun = tmpFun  - sum +  nums.length * nums[i-1];
            maxFun = Math.max(tmpFun,maxFun);
        }
        return maxFun;
    }


//    public static int maxRotateFunction(int[] nums) {
//        if(null == nums || nums.length == 0){
//            return 0;
//        }
//
//        int max = Integer.MIN_VALUE;
//        for(int i = 0 ; i < nums.length ; i++){
//            int res = compute(i,nums);
//            max = Math.max(res,max);
//        }
//        return max;
//    }
//
//    private static int compute(int k, int[] nums) {
//        int res = 0;
//        int length = nums.length;
//        for(int j = 0 ; j < nums.length ; j++){
//            //顺时针旋转k位后的位置
//            int curIndex = (length - k + j) % length;
//            if(curIndex > length -1  ){
//                curIndex = j - k;
//            }
//            res += j*nums[curIndex];
//        }
//        return res;
//    }
}
