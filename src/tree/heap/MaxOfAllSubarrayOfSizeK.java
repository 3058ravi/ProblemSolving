package tree.heap;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

public class MaxOfAllSubarrayOfSizeK {
    public static void main(String[] args){
        int arr[] = { 8, 5, 10, 7, 9, 4, 15, 12, 90, 13 };
        int k = 4, n = arr.length;

        List<Integer> res = findKMaxElement(arr, n, k);
        for (int x : res)
            System.out.print(x + " ");
    }



    public static List<Integer> findKMaxElement(int[] arr, int n, int k){
        PriorityQueue<Integer> pq= new PriorityQueue<>(Collections.reverseOrder());
        ArrayList<Integer> res = new ArrayList<>();

        for(int i=0; i<k; i++)
            pq.add(arr[i]);

        res.add(pq.peek());
        pq.remove(arr[0]);

        for(int i=k; i<n; i++){
            pq.add(arr[i]);
            res.add(pq.peek());
            pq.remove(arr[i-k+1]);
        }
        return res;
    }
}
