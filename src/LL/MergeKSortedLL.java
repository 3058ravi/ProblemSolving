package LL;

import utils.CommonUtils;
import utils.ListNode;

import java.util.PriorityQueue;

public class MergeKSortedLL {
    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(3);
        ListNode l2 = new ListNode(1);
        l2.next = new ListNode(3);
        l2.next.next = new ListNode(4);
        ListNode l3 = new ListNode(2);
        l3.next = new ListNode(4);

        ListNode[] lists = {l1, l2, l3};
        ListNode n = mergeKSortedLL(lists);
        CommonUtils.printLinkedList(n);

    }

    public static ListNode mergeKSortedLL(ListNode[] l) {
        if (l == null || l.length == 0)
            return null;
        PriorityQueue<ListNode> pq = new PriorityQueue<>((l1, l2) -> l1.getData() - l2.getData());

        ListNode head = new ListNode(0);
        ListNode tail = head;
        for (ListNode n : l)
            if (n != null)
                pq.add(n);

        while (!pq.isEmpty()) {
            tail.next = pq.poll();
            tail=tail.next;

            if(tail.next!=null)
                pq.add(tail.next);
        }
        return head.next;
    }
}
