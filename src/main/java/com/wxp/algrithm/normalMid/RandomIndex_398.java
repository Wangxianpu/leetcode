package com.wxp.algrithm.normalMid;

import java.util.Random;

/**
 * @description: 随机数索引
 * @author: wxp
 * @time: 2022/4/25 20:45
 */
public class RandomIndex_398 {

    public static void main(String[] args) throws InterruptedException {
        while (true){
            System.out.println(new RandomIndex_398(new int[]{1, 2, 3, 3, 3}).pick(3));
            Thread.sleep(500);
        }
    }
    private int[] nums ;

    public  RandomIndex_398(int[] nums) {
        this.nums = nums;
    }

    public int pick(int target) {
        //记录有多少个target
        int count = 0;
        for(int num : nums){
            if(num == target){
                count++;
            }
        }
        if(count == 0){
            return 0;
        }

        //遍历数组，取出随机的第random个target，返回其下标
        int random = new Random().nextInt(count) + 1;
        count = 0;
        for(int i = 0; i < nums.length ; i++){
            if(nums[i] == target){
                count++;
            }
            if(count == random){
                return i;
            }
        }
        return 0;
    }


}
