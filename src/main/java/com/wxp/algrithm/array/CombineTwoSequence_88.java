package com.wxp.algrithm.array;

import com.google.gson.Gson;

/**
 * @description:
 * @author: wxp
 * @time: 2022/4/5 21:32
 */
public class CombineTwoSequence_88 {
    public static void main(String[] args) {
        Gson gson = new Gson();

        //num1有效长度
        int m = 0;
        //nums2数组长度
        int n = 3;
        int[] nums1 = new int[]{0,0,0};
        int[] nums2 = new int[]{2,5,6};
        merge(nums1,m,nums2,n);
        System.out.println(gson.toJson(nums1));

    }

    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        if(m == 0){
            if (n >= 0) System.arraycopy(nums2, 0, nums1, 0, n);
        }
        if(n == 0){
            return;
        }

        int[] arr1 = new int[m];
        System.arraycopy(nums1, 0, arr1, 0, m);
        int cursorM = 0;
        int cursorN = 0;
        while(cursorM < m && cursorN < n){
            if(arr1[cursorM] <= nums2[cursorN]){
                nums1[cursorM + cursorN] = arr1[cursorM];
                cursorM++;
            }else {
                nums1[cursorM + cursorN] = nums2[cursorN];
                cursorN++;
            }
        }
        if(cursorM >= m){
            System.arraycopy(nums2, cursorN, nums1, cursorM+cursorN, n - cursorN);
        }
        if(cursorN >= n){
            System.arraycopy(arr1, cursorM, nums1, cursorM+cursorN, m - cursorM);
        }
    }
}
