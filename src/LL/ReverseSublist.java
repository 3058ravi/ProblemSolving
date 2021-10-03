package LL;

import utils.CommonUtils;
import utils.ListNode;

import java.util.List;

public class ReverseSublist {

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(3);
        l1.next.next.next = new ListNode(4);
        l1.next.next.next.next = new ListNode(5);
        l1.next.next.next.next.next = new ListNode(6);
        ListNode n = reverseSubList(l1, 2, 4);
        CommonUtils.printLinkedList(n);
    }

    public static ListNode reverseSubList(ListNode head, int start, int end) {
        if (start == end)
            return head;
        ListNode curr = head, prev = null;

        for (int i = 0; curr != null && i < start - 1; i++) {
            prev = curr;
            curr = curr.next;
        }
        ListNode lastNodeOfFirstList = prev;
        ListNode lastNodeOfSublist = curr;

        ListNode next = null;
        for (int i = 0; curr != null && i < end - start + 1; i++) {
            next = curr.next;
            curr.next=prev;
            prev=curr;
            curr=next;
        }
        if(lastNodeOfFirstList!=null)
            lastNodeOfFirstList.next=prev;

        else
            head=prev;

        lastNodeOfSublist.next=curr;

        return head;
    }

    public static void reverseLL(ListNode current, int p, int q) {

    }
}
