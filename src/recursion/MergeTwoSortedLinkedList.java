package recursion;

import utils.CommonUtils;
import utils.LNode;

public class MergeTwoSortedLinkedList {
    public static void main(String args[]){
        LNode n1 = new LNode(1);
        LNode n2 = new LNode(3);
        LNode n3 = new LNode(5);
        LNode n4 = new LNode(7);
        LNode n5 = new LNode(9);
        n1.setNext(n2);
        n2.setNext(n3);
        n3.setNext(n4);
        n4.setNext(n5);

        LNode n6 = new LNode(0);
        LNode n7 = new LNode(2);
        LNode n8 = new LNode(4);
        LNode n9 = new LNode(6);
        LNode n10 = new LNode(8);
        n6.setNext(n7);
        n7.setNext(n8);
        n8.setNext(n9);
        n9.setNext(n10);

        LNode curr= mergeTwoSortedLinkedList(n1,n6);
        CommonUtils.printLinkedList(curr);
    }

    public static LNode mergeTwoSortedLinkedList(LNode n1, LNode n2){
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
