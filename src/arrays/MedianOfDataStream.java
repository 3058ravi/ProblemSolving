package arrays;


import java.io.IOException;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;

public class MedianOfDataStream {
    public static PriorityQueue<Integer> small;
    public static PriorityQueue<Integer> large;

    public static void main(String[] args) throws IOException {
        small = new PriorityQueue<>(Collections.reverseOrder());
        large = new PriorityQueue<>();
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNext()){
            int n= scanner.nextInt();
            System.out.println("Added number "+n);
            addNumberinQueue(n);
        }

    }

    public static void addNumberinQueue(int num){
        if(small.isEmpty() && large.isEmpty()){
            small.add(num);
            findMedian();
            return;
        }

        if(small.size()>large.size()){
            if(num>small.peek()){
                large.add(num);
            }else{
                large.add(small.poll());
                small.add(num);
            }
        }else{
            if(num<large.peek()){
                small.add(num);
            }else{
                small.add(large.poll());
                large.add(num);
            }
        }
        findMedian();
    }

    public static void findMedian() {
        double median;
        if(small.size()==large.size())
            median= (double)(small.peek()+large.peek())/2;
        else
            median= small.peek();

        System.out.println("Median: "+median);
    }
}
