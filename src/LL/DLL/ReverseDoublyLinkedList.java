package LL.DLL;

import utils.CommonUtils;
import utils.DLNode;

public class ReverseDoublyLinkedList {


    public static void main(String[] args) {
        DLNode head = new DLNode(1);
        head.next = new DLNode(2, head);
        head.next.next = new DLNode(3, head.next);

        System.out.println("Before reversal");
        CommonUtils.printDoublyLinkedList(head);
        System.out.println("\nAfter reversal");
        DLNode h = reverse(head, null);
        CommonUtils.printDoublyLinkedList(h);
    }

    public static DLNode reverse(DLNode head, DLNode prev) {
        if (head == null)
            return prev;
        DLNode next = head.next;
        head.next = prev;
        head.prev = next;
        return reverse(next, head);
    }


}
