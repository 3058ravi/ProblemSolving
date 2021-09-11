package recursion;

import utils.CommonUtils;
import utils.ListNode;

public class MergeTwoSortedLinkedList {
    public static void main(String args[]){
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(3);
        ListNode n3 = new ListNode(5);
        ListNode n4 = new ListNode(7);
        ListNode n5 = new ListNode(9);
        n1.setNext(n2);
        n2.setNext(n3);
        n3.setNext(n4);
        n4.setNext(n5);

        ListNode n6 = new ListNode(0);
        ListNode n7 = new ListNode(2);
        ListNode n8 = new ListNode(4);
        ListNode n9 = new ListNode(6);
        ListNode n10 = new ListNode(8);
        n6.setNext(n7);
        n7.setNext(n8);
        n8.setNext(n9);
        n9.setNext(n10);

        ListNode curr= mergeTwoSortedLinkedList(n1,n6);
        CommonUtils.printLinkedList(curr);
    }

    public static ListNode mergeTwoSortedLinkedList(ListNode n1, ListNode n2){
        if(n1==null) return n2;
        if(n2==null) return n1;
        if(n1.getData()<n2.getData()){
            n1.next=mergeTwoSortedLinkedList(n1.next,n2);
            return n1;
        }else{
            n2.next=mergeTwoSortedLinkedList(n1,n2.next);
            return n2;
        }
    }
}
