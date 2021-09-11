package LL;

import utils.CommonUtils;
import utils.ListNode;

public class SwapNodesInPair {
    public static ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null)
            return head;

        ListNode first = head;
        ListNode prev = head.next;
        while (first != null && first.next != null) {
            ListNode temp = first;
            first = first.next;
            temp.next = first.next;
            first.next = temp;
            first = temp.next;
            if (first != null && first.next != null)
                temp.next = first.next;
        }
        return prev;
    }

    public static ListNode swapPairsUsingRecursion(ListNode head) {
        if (head == null || head.next == null)
            return head;
        ListNode n = head.next;
        head.next = swapPairsUsingRecursion(head.next.next);
        n.next = head;
        return n;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(3);
        l1.next.next.next = new ListNode(4);
        l1.next.next.next.next = new ListNode(5);
        l1.next.next.next.next.next = new ListNode(6);
        ListNode n = swapPairs(l1);
        CommonUtils.printLinkedList(n);

        ListNode l2 = new ListNode(1);
        l2.next = new ListNode(2);
        l2.next.next = new ListNode(3);
        l2.next.next.next = new ListNode(4);
        l2.next.next.next.next = new ListNode(5);
        l2.next.next.next.next.next = new ListNode(6);
        ListNode m = swapPairsUsingRecursion(l2);
        CommonUtils.printLinkedList(n);

    }

}
