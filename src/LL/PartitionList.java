package LL;

import utils.CommonUtils;
import utils.ListNode;

public class PartitionList {
        public static ListNode partition(ListNode head, int x) {
            ListNode dummy1 = new ListNode(0), dummy2 = new ListNode(0);  //dummy heads of the 1st and 2nd queues
            ListNode curr1 = dummy1, curr2 = dummy2;      //current tails of the two queues;
            while (head!=null){
                if (head.getData()<x) {
                    curr1.next = head;
                    curr1 = head;
                }else {
                    curr2.next = head;
                    curr2 = head;
                }
                head = head.next;
            }
            curr2.next = null;          //important! avoid cycle in linked list. otherwise u will get TLE.
            curr1.next = dummy2.next;
            return dummy1.next;
        }

    public static void main(String[] args) {

//        ListNode l1 = new ListNode(2);
//        l1.next = new ListNode(1);

        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(3);
        l1.next.next.next = new ListNode(0);
        l1.next.next.next.next = new ListNode(2);
        l1.next.next.next.next.next = new ListNode(5);
        l1.next.next.next.next.next.next = new ListNode(2);
        ListNode n = partition(l1,3);
        CommonUtils.printLinkedList(n);
    }
}
