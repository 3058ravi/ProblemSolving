package LL;

import utils.ListNode;

public class MiddleOfLinkedList {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(6);
        findMiddle(head);
    }

    public static void findMiddle(ListNode head) {
        int length = 0;
        ListNode curr = head;
        ListNode middle = head;

        while (curr.next != null) {
            length++;
            if (length % 2 == 0)
                middle = middle.next;

            curr = curr.next;
        }
        if (length % 2 == 1)
            middle = middle.next;

        System.out.println("Length of Linked List is:" + (length + 1));
        System.out.println("Middle of list is " + middle.getData());
    }
}
