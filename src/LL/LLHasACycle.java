package LL;

import utils.ListNode;

import java.util.HashMap;
import java.util.LinkedHashMap;

public class LLHasACycle {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next = head.next;
       System.out.println( hasACycle(head));
    }

    public static boolean hasACycle(ListNode head) {
        if (head == null) return false;
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow)
                return true;
        }
        return false;

    }

}
