package LL;

import utils.CommonUtils;
import utils.ListNode;
import utils.TNode;

public class ConvertLLIntoBST {

    public static void main(String[] args){
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(3);
        l1.next.next.next = new ListNode(4);
        l1.next.next.next.next = new ListNode(5);
        l1.next.next.next.next.next = new ListNode(6);

        TNode root= convertLLIntoBST(l1);
        CommonUtils.printInOrderTree(root);
    }
    public static TNode convertLLIntoBST(ListNode head){
        if(head==null || head.next==null)
            return new TNode(head.getData());
        return convertLLIntoBST(head,null);
    }


    public static TNode convertLLIntoBST(ListNode head,ListNode tail){


        ListNode fast=head;
        ListNode slow=head;
        if(head==tail) return null;
        while(fast!=tail && fast.next!=tail){
            fast=fast.next.next;
            slow=slow.next;
        }
        TNode root= new TNode(slow.getData());
        root.left=convertLLIntoBST(head,slow);
        root.right=convertLLIntoBST(slow.next,tail);
        return root;
    }
}
