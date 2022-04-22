package com.wxp.algrithm.queue;


import com.google.gson.Gson;

/**
 * @description:
 * @author: wxp
 * @time: 2022/4/3 18:09
 */
public class CombineQueue {

    public static void main(String[] args) {

        ListNode listNode1 = new ListNode(1);
        listNode1.next=new ListNode(2);
        listNode1.next.next = new ListNode(4);

        ListNode listNode2 = new ListNode(1);
        listNode2.next=new ListNode(3);
        listNode2.next.next = new ListNode(4);

        Gson gson = new Gson();
        System.out.println(gson.toJson(mergeTwoLists(listNode1,listNode2)));
    }

    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if(list1 == null && list2 == null){
            return null;
        }
        if(list1 == null  || list2 == null){
            return list1 == null ? list2 : list1;
        }

        ListNode smallNode ;
        ListNode largeNode ;
        //筛选出头结点较小的列表
        if(list1.val <= list2.val){
            smallNode = list1;
            largeNode = list2;
        }else{
            smallNode = list2;
            largeNode = list1;
        }

        //返回的node
        ListNode retNode = new ListNode(smallNode.val);
        smallNode = smallNode.next;
        ListNode tmpNode = retNode;
        while (smallNode != null && largeNode != null){
            if(largeNode.val <= smallNode.val  ){
                tmpNode.next = new ListNode(largeNode.val);
                largeNode = largeNode.next;
            }else{
                tmpNode.next = new ListNode(smallNode.val);
                smallNode = smallNode.next;
            }
            tmpNode = tmpNode.next;
        }

        if (smallNode != null){
            tmpNode.next = smallNode;
        }
        if (largeNode != null){
            tmpNode.next = largeNode;
        }

        return retNode;
    }
}


