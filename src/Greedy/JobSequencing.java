package Greedy;

import java.util.ArrayList;
import java.util.Collections;


public class JobSequencing {
    static class Job {
        char id;
        int deadline, profit;

        public Job(char id, int deadline, int profit) {
            this.id = id;
            this.deadline = deadline;
            this.profit = profit;
        }
    }

    public static void main(String[] args) {
        ArrayList<Job> arr = new ArrayList<>();
        arr.add(new Job('a', 2, 100));
        arr.add(new Job('b', 1, 19));
        arr.add(new Job('c', 2, 27));
        arr.add(new Job('d', 1, 25));
        arr.add(new Job('e', 3, 15));
        printJobScheduling(arr, 3);
    }

    public static void printJobScheduling(ArrayList<Job> arr, int t) {
        int n = arr.size();
        Collections.sort(arr,
                (a, b) -> b.profit - a.profit);

        boolean result[] = new boolean[t];
        char job[] = new char[t];

        for (int i = 0; i < n; i++) {
            // Find a free slot for this job
            // (Note that we start from the
            // last possible slot)
            for (int j = Math.min(t - 1, arr.get(i).deadline - 1);
                 j >= 0; j--) {

                // Free slot found
                if (result[j] == false) {
                    result[j] = true;
                    job[j] = arr.get(i).id;
                    break;
                }
            }
        }
        for (char jb : job) {
            System.out.print(jb + " ");
        }
        System.out.println();

    }
}
