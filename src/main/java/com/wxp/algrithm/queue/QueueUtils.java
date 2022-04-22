package com.wxp.algrithm.queue;

import com.google.gson.Gson;

/**
 * @description:
 * @author: wxp
 * @time: 2022/4/8 21:29
 */
public class QueueUtils {

    /**
     * 创建单向链表
     * @param arr 数组
     */
    public static ListNode createSingleQueue(int[] arr){
        if(arr == null || arr.length == 0){
            return null;
        }
        ListNode queue = new ListNode();
        ListNode tmpQueue = queue;
        for (int num : arr) {
            tmpQueue.next = new ListNode(num);
            tmpQueue = tmpQueue.next;
        }
        return queue.next;
    }

    public static void main(String[] args) {
        Gson gson = new Gson();
        System.out.println(gson.toJson(createSingleQueue(new int[]{2,5,-5,5,67})));
    }

}
