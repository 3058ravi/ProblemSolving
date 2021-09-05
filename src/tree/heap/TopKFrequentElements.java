package tree.heap;

import java.util.*;

public class TopKFrequentElements {

    public static void main(String[] args){
        int[] arr={1, 2, 3, 1, 2, 1,3,2,3,2,3};
        int k = 2;
        topKFrequentElements(arr,k);
    }

    public static void topKFrequentElements(int[]  arr, int k){
        Map<Integer, Integer> map = new HashMap<>();

        for(int n: arr){
            map.put(n, map.getOrDefault(n,0)+1);
        }

        PriorityQueue<Map.Entry<Integer,Integer>> pq= new PriorityQueue<>((a,b)->(b.getValue()-a.getValue()));
        for(Map.Entry<Integer,Integer> entry: map.entrySet()){
            pq.add(entry);
        }

int i=0;
        while(i<k){
           System.out.println(pq.poll().getKey());
           i++;
        }
    }
}
