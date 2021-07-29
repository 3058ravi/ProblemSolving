package recursion;

import utils.CommonUtils;
import utils.Node;

public class MergeTwoSortedLinkedList {
    public static void main(String args[]){
        Node n1 = new Node(1);
        Node n2 = new Node(3);
        Node n3 = new Node(5);
        Node n4 = new Node(7);
        Node n5 = new Node(9);
        n1.setNext(n2);
        n2.setNext(n3);
        n3.setNext(n4);
        n4.setNext(n5);

        Node n6 = new Node(0);
        Node n7 = new Node(2);
        Node n8 = new Node(4);
        Node n9 = new Node(6);
        Node n10 = new Node(8);
        n6.setNext(n7);
        n7.setNext(n8);
        n8.setNext(n9);
        n9.setNext(n10);

        Node curr= mergeTwoSortedLinkedList(n1,n6);
        CommonUtils.printLinkedList(curr);
    }

    public static Node mergeTwoSortedLinkedList(Node n1, Node n2){
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
