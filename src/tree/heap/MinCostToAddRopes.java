package tree.heap;

import java.util.PriorityQueue;

public class MinCostToAddRopes {
    public static void main(String[] args) {
        int[] a = {4, 3, 2, 6};
        int n = a.length;
        System.out.println(minCostToAddRopes(a, n));
    }

    public static int minCostToAddRopes(int[] arr, int n) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int i = 0; i < n; i++) {
            pq.add(arr[i]);
        }

        int res=0;

        while(pq.size()>1){
            int min_f=pq.poll();
            int min_s=pq.poll();
            res= res+min_f+min_s;
            pq.add(min_f+min_s);
        }

        return res;
    }
}
