package com.wxp.algrithm.queue;

/**
 * @description: 环形链表检测
 * @author: wxp
 * @time: 2022/4/8 21:13
 */
public class CycleQueue_141 {

    public static void main(String[] args) {
        //head = [3,2,0,-4], pos = 1
        //[-1,-7,7,-4,19,6,-9,-5,-2,-5]   6
        ListNode listNode = QueueUtils.createSingleQueue(new int[]{-1,-7,7,-4,19,6,-9,-5,-2,-5});
        ListNode tmpNode = listNode;
        while(tmpNode.next != null){
            tmpNode = tmpNode.next;
        }
        tmpNode.next = listNode.next.next.next.next.next;

        System.out.println("\n\n" + hasCycle(listNode));
    }

    public static boolean hasCycle(ListNode head) {
        //如果没有节点或是只有一个节点，那么必点不是环路
        if(head == null || head.next == null){
            return false;
        }
        ListNode node = head;
        //使用快慢指针进行判断，如果两节点相遇，则出现环路
        while(true){
            if(node.next != null && node.next.next != null){
                node = node.next.next;
            }else {
                break;
            }
            head = head.next;

            if(head == node){
                return true;
            }
        }
        return false;
    }

}
