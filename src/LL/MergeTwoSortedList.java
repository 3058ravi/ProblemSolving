package LL;

import utils.CommonUtils;
import utils.ListNode;

public class MergeTwoSortedList {


    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode head = null;
        ListNode prev = new ListNode(0);
        while (l1 != null && l2 != null) {
            if (l1.getData() < l2.getData()) {
                ListNode new_node = new ListNode(l1.getData());
                if (head == null)
                    head = new_node;
                prev.next = new_node;
                prev = prev.next;
                l1 = l1.next;
            } else {
                ListNode new_node = new ListNode(l2.getData());
                if (head == null)
                    head = new_node;
                prev.next = new_node;
                prev = prev.next;
                l2 = l2.next;
            }
        }
        while(l1!=null) {
            prev.next=new ListNode(l1.getData());
            prev= prev.next;
            l1=l1.next;
        }
        while(l2!=null) {
            prev.next=new ListNode(l2.getData());
            prev= prev.next;
            l2=l2.next;
        }
        return head;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(3);
        ListNode l2 = new ListNode(1);
        l2.next = new ListNode(3);
        l2.next.next = new ListNode(4);

        ListNode n = mergeTwoLists(l1, l2);
        CommonUtils.printLinkedList(n);

    }
}
