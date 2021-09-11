package LL;

import utils.CommonUtils;
import utils.ListNode;

public class ReverseLL {
    public static ListNode reverseList(ListNode head) {
        ListNode node = head;
        ListNode prev = null;
        while (node.next != null) {
            ListNode temp = node;

            node = node.next;
            temp.next = prev;
            prev = temp;
        }
        node.next = prev;
        head = node;

        return head;

    }

    public static ListNode reverseListUsingRecursion(ListNode head, ListNode prev) {
        if (head == null)
            return prev;
        ListNode next = head.next;
        head.next = prev;
        return reverseListUsingRecursion(next, head);

    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(3);
        l1.next.next.next = new ListNode(4);
        l1.next.next.next.next = new ListNode(5);
        l1.next.next.next.next.next = new ListNode(6);
        ListNode n = reverseList(l1);
        CommonUtils.printLinkedList(n);

        ListNode l2 = new ListNode(1);
        l2.next = new ListNode(2);
        l2.next.next = new ListNode(3);
        l2.next.next.next = new ListNode(4);
        l2.next.next.next.next = new ListNode(5);
        l2.next.next.next.next.next = new ListNode(6);
        ListNode m = reverseListUsingRecursion(l2,null);
        CommonUtils.printLinkedList(m);
    }

}
