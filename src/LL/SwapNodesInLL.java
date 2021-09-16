package LL;

import utils.CommonUtils;
import utils.ListNode;

public class SwapNodesInLL {
        public static ListNode swapNodes(ListNode head, int k) {
            if(head==null || head.next==null)
                return null;

            ListNode fast=head, slow=head;
            int i=0 ;
            while(i<k-1 && fast.next!=null){
                fast=fast.next;
                i++;
            }
            ListNode first=fast;

            while(fast.next!=null){
                slow=slow.next;
                fast=fast.next;
            }

            ListNode second= slow;
            int temp=second.getData();
            second.setData(first.getData());
            first.setData(temp);


            return head;
        }
        public static void main(String[] args){
            ListNode l1 = new ListNode(1);
            l1.next = new ListNode(2);
            l1.next.next = new ListNode(3);
            l1.next.next.next = new ListNode(4);
            l1.next.next.next.next = new ListNode(5);
            l1.next.next.next.next.next = new ListNode(6);
            ListNode n=swapNodes(l1,2);
            CommonUtils.printLinkedList(n);
    }
}
