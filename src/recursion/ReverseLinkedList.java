package recursion;

import utils.CommonUtils;
import utils.LNode;
public class ReverseLinkedList {

    public static void main(String[] args) {
        LNode n1 = new LNode(1);
        LNode n2 = new LNode(2);
        LNode n3 = new LNode(3);
        LNode n4 = new LNode(4);
        LNode n5 = new LNode(5);

        n1.setNext(n2);
        n2.setNext(n3);
        n3.setNext(n4);
        n4.setNext(n5);
        CommonUtils.printLinkedList(n1);
        LNode reverse=reverseLinkedList(n1);
        System.out.println("\nReversed list is");
        CommonUtils.printLinkedList(reverse);
    }

    public static LNode reverseLinkedList(LNode LNode){
        if(LNode ==null|| LNode.next==null)
            return LNode;
       LNode p=reverseLinkedList(LNode.next);
       LNode.next.next= LNode;
       LNode.next=null;
       return p;

    }

}
