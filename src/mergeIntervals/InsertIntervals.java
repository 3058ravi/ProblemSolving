package mergeIntervals;

import java.util.*;

public class InsertIntervals {
    static class Interval {
        int start;
        int end;

        public Interval(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

    public static void main(String[] args) {
        List<Interval> list = new ArrayList<>();
        list.add(new Interval(1, 3));
        list.add(new Interval(5, 7));
        list.add(new Interval(8, 12));
        List<Interval> merged = insertInterval(list, new Interval(4, 6));
        for (Interval i : merged) {
            System.out.println(i.start + " : " + i.end);
        }
    }

    public static List<Interval> insertInterval(List<Interval> list, Interval insert) {
        if (list == null || list.isEmpty())
            return Arrays.asList(insert);
        List<Interval> merged = new LinkedList<>();

        int i = 0;
        while (i<list.size() && list.get(i).end < insert.start) {
            merged.add(list.get(i++));
        }

        while(i<list.size() && list.get(i).start<= insert.end){
            insert.start= Math.min(list.get(i).start,insert.start);
            insert.end= Math.max(list.get(i).end, insert.end);
            i++;
        }

        merged.add(insert);
        while (i<list.size() ) {
            merged.add(list.get(i++));
        }
        return merged;
    }
}
