package mergeIntervals;

import java.util.*;

public class MergeInterval {
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
        list.add(new Interval(6, 7));
        list.add(new Interval(2, 4));
        list.add(new Interval(3, 5));
        List<Interval> merged = mergeInterval(list);
        for (Interval i : merged) {
            System.out.println(i.start + " : " + i.end);
        }
    }

    public static List<Interval> mergeInterval(List<Interval> list) {
        if (list.size() < 2)
            return list;
        Collections.sort(list, (a, b) -> Integer.compare(a.start, b.start));
        List<Interval> merged = new LinkedList<>();
        Iterator<Interval> itr = list.iterator();
        Interval interval = itr.next();
        int startTime = interval.start;
        int endTime = interval.end;

        while (itr.hasNext()) {
            interval = itr.next();
            if (interval.start <= endTime)
                endTime = Math.max(interval.end, endTime);
            else {
                merged.add(new Interval(startTime, endTime));
                startTime = interval.start;
                endTime = interval.end;
            }
        }
        merged.add(new Interval(startTime,endTime));

        return merged;
    }
}
