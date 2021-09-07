package LL;

import utils.LNode;

public class MiddleOfLinkedList {
    public static void main(String[] args){
        LNode head= new LNode(1);
        head.next= new LNode(2);
        head.next.next= new LNode(3);
        head.next.next.next= new LNode(4);
        head.next.next.next.next= new LNode(5);
        head.next.next.next.next.next= new LNode(6);

    int length=0;
    LNode curr=head;
    LNode middle=head;

    while(curr.next!=null){
        length++;
        if(length%2==0)
            middle=middle.next;

        curr=curr.next;
    }
    if(length%2==1)
        middle=middle.next;

    System.out.println("Length of Linked List is:"+ (length+1));
    System.out.println("Middle of list is "+middle.getData());
    }
}
