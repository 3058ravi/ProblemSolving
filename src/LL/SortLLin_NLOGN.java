package LL;

import utils.CommonUtils;
import utils.ListNode;

public class SortLLin_NLOGN {
    public static void main(String[] args){
        ListNode l1 = new ListNode(6);
        l1.next = new ListNode(5);
        l1.next.next = new ListNode(4);
        l1.next.next.next = new ListNode(3);
        l1.next.next.next.next = new ListNode(2);
        l1.next.next.next.next.next = new ListNode(1);
        ListNode n=sort(l1);
        CommonUtils.printLinkedList(n);

    }

    public static ListNode sort(ListNode head){
        if(head==null||head.next==null)
            return head;
        ListNode slow=head, fast=head.next;
        while(fast!=null&& fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        ListNode tail=slow.next;
        slow.next=null;

        ListNode l1= sort(head);
        ListNode l2= sort(tail);
        return merge(l1,l2);
    }

    public static ListNode merge(ListNode l1, ListNode l2){
        if(l1==null) return  l2;
        if(l2==null) return l1;
        if(l1.getData()<l2.getData()) {
            l1.next = merge(l1.next, l2);
            return l1;
        }else {
            l2.next = merge(l1, l2.next);
            return l2;
        }
    }
}
