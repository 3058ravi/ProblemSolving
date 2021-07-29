package utils;

public class CommonUtils {
    public static void printArray(int[] arr) {
        for (int a : arr) {
            System.out.print(a + " ");
        }
        System.out.println();
    }

    public static void printLinkedList(Node node) {
        Node curr=node;
        while (curr != null) {
            System.out.print(curr.getData() + " ");
            curr = curr.next;
        }
    }

    public static void printInOrderTree(TNode node){
        TNode head= node;
        if(head!=null) {
            printInOrderTree(head.left);
            System.out.print(head.getData() + " ");
            printInOrderTree(head.right);
        }
    }
}
