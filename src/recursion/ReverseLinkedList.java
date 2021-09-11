package recursion;

import utils.CommonUtils;
import utils.ListNode;
public class ReverseLinkedList {

    public static void main(String[] args) {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(4);
        ListNode n5 = new ListNode(5);

        n1.setNext(n2);
        n2.setNext(n3);
        n3.setNext(n4);
        n4.setNext(n5);
        CommonUtils.printLinkedList(n1);
        ListNode reverse=reverseLinkedList(n1);
        System.out.println("\nReversed list is");
        CommonUtils.printLinkedList(reverse);
    }

    public static ListNode reverseLinkedList(ListNode ListNode){
        if(ListNode ==null|| ListNode.next==null)
            return ListNode;
       ListNode p=reverseLinkedList(ListNode.next);
       ListNode.next.next= ListNode;
       ListNode.next=null;
       return p;

    }

}
