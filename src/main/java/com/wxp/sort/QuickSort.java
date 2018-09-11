package com.wxp.sort;

import java.util.Arrays;

/**
 * Created by 10521 on 2018/9/10.
 */
public class QuickSort {
    public static void main(String[] args) {
        int[] arr = new int[]{ 5,2,8,9,6,3,4,9};
        sqort2(arr,0,arr.length-1);
        System.out.print(Arrays.toString(arr));
    }

    private static void sqort(int[] arr,int start,int end) {
        if(start >= end){
            return;
        }
        int tmp = start;
        int index = -1 ;
        for(int i = start ; i <= end ; i++){
            if(arr[tmp] > arr[i]){
                swap(arr,tmp,i);
                tmp++;
                index = i;
            }
        }
        if(index != -1){
            for(int i = end ; i >= start ; i--){
                if(arr[index] < arr[i]){
                    swap(arr,index,i);
                    index--;
                }
            }
        }
        sqort(arr,start,tmp-1);
        sqort(arr,tmp+1,end);
    }

    private static void sqort2(int[] arr , int start , int end){
        if(start >= end ) return;
        int low = start;
        int high =end ;
        int tmp = arr[start];
        while(low < high){
            //取最右边的第一个小于tmp的云素
            while(tmp <= arr[high] && low < high){
                high--;
            }
            //取左边的第一个大于tmp的云素
            while(tmp >= arr[low] && low < high){
                low++;
            }
            swap(arr,low,high);
        }
        arr[start] = arr[low];
        arr[low] = tmp ;
        sqort2(arr,start,low-1);
        sqort2(arr,low + 1 ,end);

    }


    private static void swap(int[] arr , int toIdx , int fromIdx){
        int tmp = arr[fromIdx];
        arr[fromIdx] = arr[toIdx];
        arr[toIdx] = tmp;
    }
}
