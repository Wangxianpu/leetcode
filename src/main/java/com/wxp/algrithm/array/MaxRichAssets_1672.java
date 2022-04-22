package com.wxp.algrithm.array;

/**
 * @description: 最富有客户的资产总量 1672
 * @author: wxp
 * @time: 2022/4/14 21:32
 */
public class MaxRichAssets_1672 {
    public static void main(String[] args) {
        int[][] accounts = new int[][]{{1,2,3},{3,2,1}};
        System.out.println(maximumWealth(accounts));
    }

    /**
     * 返回最大的资产总数
     */
    public static int maximumWealth(int[][] accounts) {
        if(accounts == null || accounts.length == 0){
            return 0;
        }
        int maxAssets = 0;
        int tmpTotal = 0;
        for (int[] account : accounts) {
            for (int i : account) {
                tmpTotal += i;
            }
            maxAssets = Math.max(maxAssets, tmpTotal);
            tmpTotal = 0;
        }
        return maxAssets;
    }
}
