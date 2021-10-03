package LL;

import utils.CommonUtils;
import utils.ListNode;

public class ReverseKLL {

    public static void main(String[] args){
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(3);
        l1.next.next.next = new ListNode(4);
        l1.next.next.next.next = new ListNode(5);
        l1.next.next.next.next.next = new ListNode(6);
        l1.next.next.next.next.next.next = new ListNode(7);
        ListNode n = reverseKList(l1,3);
        CommonUtils.printLinkedList(n);
    }

    public static ListNode reverseKList(ListNode head, int k){
        ListNode node=head;
        ListNode curr_head=head;
        ListNode tail=head;
        int i=0;
        if(head==null)
            return head;
        while(i<k && node!=null){
            node=node.next;
            i++;
        }
        if(i==k){
            node=reverseKList(node,k);
            ListNode prev=null;
            while(--k >0){
                ListNode temp= curr_head;

                curr_head=curr_head.next;
                 temp.next=prev;
                 prev=temp;

            }
            tail.next=node;
            curr_head.next=prev;
        }else{
            return head;
        }
        return curr_head;
    }
}
