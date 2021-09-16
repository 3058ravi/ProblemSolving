package LL;

import utils.CommonUtils;
import utils.ListNode;

public class InsertionSort {

    public static void main(String[] args){
        ListNode l1 = new ListNode(6);
        l1.next = new ListNode(5);
        l1.next.next = new ListNode(4);
        l1.next.next.next = new ListNode(3);
        l1.next.next.next.next = new ListNode(2);
        l1.next.next.next.next.next = new ListNode(1);
        ListNode n=insertionSort(l1);
        CommonUtils.printLinkedList(n);

    }

    public static ListNode insertionSort(ListNode head){
        if(head==null|| head.next==null)
            return head;
        ListNode pre= new ListNode(0);
        ListNode first=pre;
        ListNode second= head;
        ListNode next=null;
        while(second!=null){
            next=second.next;
            while(first.next!=null&& second.getData()>first.next.getData())
                first=first.next;

            second.next=first.next;
            first.next=second;
            first=pre;
            second=next;

        }
        return pre.next;
    }
}
