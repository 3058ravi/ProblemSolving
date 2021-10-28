package utils;

import java.util.List;
import java.util.ListIterator;

public class CommonUtils {
    public static void printArray(int[] arr) {
        for (int a : arr) {
            System.out.print(a + " ");
        }
        System.out.println();
    }

    public static void printArray(int[][] arr) {
        for (int[] a : arr) {
            for (int b : a) {
                System.out.print(b + " ");
            }
            System.out.println();
        }
    }

    public static void printIntegerList(List<Integer> list) {
        ListIterator<Integer> listIterator= list.listIterator();
       while(listIterator.hasNext())
           System.out.print(listIterator.next()+" ");
        System.out.println();
    }

    public static void printLinkedList(ListNode ListNode) {
        ListNode curr= ListNode;
        while (curr != null) {
            System.out.print(curr.getData() + " ");
            curr = curr.next;
        }
        System.out.println("");
    }

    public static void printDoublyLinkedList(DLNode ListNode) {
        DLNode curr= ListNode;
        while (curr != null) {
            System.out.print(curr.getData() + " ");
            curr = curr.next;
        }
        System.out.println("");
    }

    public static void printInOrderTree(TNode node){
        TNode head= node;
        if(head!=null) {
            printInOrderTree(head.left);
            System.out.print(head.getData() + " ");
            printInOrderTree(head.right);
        }
    }

    public static void printPreOrderTree(TNode node){
        TNode head= node;
        if(head!=null) {
            System.out.print(head.getData() + " ");
            printPreOrderTree(head.left);
            printPreOrderTree(head.right);
        }
    }

    public static void printPostOrderTree(TNode node){
        TNode head= node;
        if(head!=null) {

            printPostOrderTree(head.left);
            printPostOrderTree(head.right);
            System.out.print(head.getData() + " ");
        }
    }
}
