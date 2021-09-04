package tree.heap;

import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class KSortedArray {

    public static void main(String[] args){
        List<Integer> list = Arrays.asList(1, 4, 5, 2, 3, 7, 8, 6, 10, 9);
        int k = 2;
        sortKSortedArray(list, k);
        System.out.println(list);
    }

    public static void sortKSortedArray(List<Integer> list,int k){
        PriorityQueue<Integer> pq= new PriorityQueue<>(list.subList(0,k+1));
        int index=0;
        for(int i=k+1; i<list.size();i++){
            list.set(index++,pq.poll());
            pq.add(list.get(i));
        }
        while (!pq.isEmpty()) {
            list.set(index++, pq.poll());
        }

    }

}
