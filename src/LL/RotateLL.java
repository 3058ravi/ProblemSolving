package LL;

import utils.CommonUtils;
import utils.ListNode;

public class RotateLL {
    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(3);
        l1.next.next.next = new ListNode(4);
        l1.next.next.next.next = new ListNode(5);
        l1.next.next.next.next.next = new ListNode(6);
        ListNode n = rotateList(l1,2);
        CommonUtils.printLinkedList(n);
    }

    public static ListNode rotateList(ListNode head, int k) {
        if(head==null|| k==0)
            return head;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode fast = dummy, slow = dummy;

        int i = 0;
        while (fast.next != null) {
            fast = fast.next;
            i++;
        }

        for(int j=i-k%i;j>0; j--)
            slow=slow.next;

        fast.next=dummy.next;
        dummy.next=slow.next;
        slow.next=null;

        return dummy.next;
    }
}
