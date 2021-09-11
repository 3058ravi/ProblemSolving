package LL;

import utils.CommonUtils;
import utils.ListNode;

public class DeleteNthNodeFromEnd {

    public static ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode start = head;
        if (head.next == null)
            return null;
        ListNode fast = start;
        ListNode slow = new ListNode(0);
        slow.next = start;
        for (int i = 0; i < n; i++)
            fast = fast.next;
        while (fast != null) {
            slow = slow.next;
            fast = fast.next;
        }
        if(slow.next==head){
            head=start.next;
            return head;
        }


        slow.next = slow.next.next;
        return head;

    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(6);
        ListNode n=removeNthFromEnd(head, 2);

        CommonUtils.printLinkedList(n);
    }
}
