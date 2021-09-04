package tree.heap;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class KthLargestNumberInArray {
    public static void main(String[] args){
        List<Integer> ints = Arrays.asList(7, 4, 6, 3, 9, 1);
        int k = 2;
        System.out.println("k'th largest array element is " + findKthLargest(ints, k));

        System.out.println("k'th smallest array element is " + findKthSmallest(ints, k));
    }

    public static int findKthLargest(List<Integer> ints,int k){
        PriorityQueue<Integer> pq= new PriorityQueue<>(ints.subList(0,2));
        for(int i=k; i<ints.size(); i++){
            if(ints.get(i)>pq.peek()){
                pq.poll();
                pq.add(ints.get(i));
            }
        }
        return pq.peek();
    }

    public static int findKthSmallest(List<Integer> ints,int k){
        PriorityQueue<Integer> pq= new PriorityQueue<>(Comparator.reverseOrder());
        pq.addAll(ints.subList(0,k));
        for(int i=k; i<ints.size(); i++){
            if(ints.get(i)<pq.peek()){
                pq.poll();
                pq.add(ints.get(i));
            }
        }
        return pq.peek();
    }

}
