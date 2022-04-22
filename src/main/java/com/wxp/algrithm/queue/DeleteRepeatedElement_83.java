package com.wxp.algrithm.queue;

import com.google.gson.Gson;

/**
 * @description:
 * @author: wxp
 * @time: 2022/4/4 21:39
 */
public class DeleteRepeatedElement_83 {

    public static void main(String[] args) {
        Gson gson = new Gson();
        ListNode  listNode = new ListNode(1);
        listNode.next = new ListNode(1);
        listNode.next.next = new ListNode(1);

        System.out.println(gson.toJson(deleteDuplicates(listNode)));

    }

    public static ListNode deleteDuplicates(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        if(head.val == head.next.val){
            head.next = head.next.next;
            deleteDuplicates(head);
        }
        deleteDuplicates(head.next);
        return head;
    }
}
