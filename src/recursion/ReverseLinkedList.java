package recursion;

import utils.CommonUtils;
import utils.Node;
public class ReverseLinkedList {

    public static void main(String[] args) {
        Node n1 = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);
        Node n4 = new Node(4);
        Node n5 = new Node(5);

        n1.setNext(n2);
        n2.setNext(n3);
        n3.setNext(n4);
        n4.setNext(n5);
        CommonUtils.printLinkedList(n1);
        Node reverse=reverseLinkedList(n1);
        System.out.println("\nReversed list is");
        CommonUtils.printLinkedList(reverse);
    }

    public static Node reverseLinkedList(Node node){
        if(node==null||node.next==null)
            return node;
       Node p=reverseLinkedList(node.next);
       node.next.next=node;
       node.next=null;
       return p;

    }

}
