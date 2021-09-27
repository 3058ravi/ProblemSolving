package mergeIntervals;

import java.util.*;

public class MinMeetingRoomRequired {
    static class Meeting{
        int start;
        int end;

        public Meeting(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

    public static void main(String[] args){
        List<Meeting> list = new ArrayList<>();
        list.add(new Meeting(4,5));
        list.add(new Meeting(2,3));
        list.add(new Meeting(3,5));
        list.add(new Meeting(2,4));

        System.out.println(findMinRoomRequired(list));
    }

    public static int findMinRoomRequired(List<Meeting> list){
        if(list==null|| list.isEmpty())
            return 0;
        Collections.sort(list, (a,b)->Integer.compare(a.start, b.start));

        int rooms=0;
        PriorityQueue<Meeting> pq= new PriorityQueue<>((a,b)->Integer.compare(a.end, b.end));

        for(Meeting m: list){
            while(!pq.isEmpty() && m.start>=pq.peek().end)
                pq.poll();

            pq.add(m);
            rooms=Math.max(rooms, pq.size());
        }
        return rooms;
    }
}
