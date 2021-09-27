package ProrityQueue;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class ActivitySelection {

    static class Activity{
        int start;
        int end;

        public Activity(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

    public static void main(String[] args){
        int s[] = { 1, 3, 0, 5, 8, 5 };
        int f[] = { 2, 4, 6, 7, 9, 9 };

        // Function call
        SelectActivities(s, f);

    }

    public static void SelectActivities(int[] s, int[] f){
        ArrayList<Activity> list = new ArrayList<>();

        PriorityQueue<Activity> q = new PriorityQueue<>((q1,q2)->q1.end - q2.end);

        for(int i=0; i<s.length; i++){
            q.add(new Activity(s[i],f[i]));
        }

        Activity a=q.poll();
        int start = a.start;
        int end = a.end;
        list.add(new Activity(start,end));

        while(!q.isEmpty()){
            Activity b = q.poll();
            if (b.start >= end) {
                start = b.start;
                end = b.end;
                list.add(new Activity(start, end));
            }
        }

        for (Activity b : list) {
            System.out.println(
                    "Activity started at: " + b.start
                            + " and ends at  " + b.end);
        }


    }


}
