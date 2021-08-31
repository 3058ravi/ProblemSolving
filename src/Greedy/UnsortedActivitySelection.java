package Greedy;
/*
* Comparable	Comparator
1) Comparable provides a single sorting sequence. In other words, we can sort the collection on the basis of a single element such as id, name, and price.
* The Comparator provides multiple sorting sequences. In other words, we can sort the collection on the basis of multiple elements such as id, name, and price etc.
2) Comparable affects the original class, i.e., the actual class is modified.
* Comparator doesn't affect the original class, i.e., the actual class is not modified.
3) Comparable provides compareTo() method to sort elements.
* Comparator provides compare() method to sort elements.
4) Comparable is present in java.lang package.
* 	A Comparator is present in the java.util package.
5) We can sort the list elements of Comparable type by Collections.sort(List) method.
* We can sort the list elements of Comparator type by Collections.sort(List, Comparator) method.
*
* */

import java.util.Arrays;
import java.util.Comparator;

class Activity {
    int start;
    int end;

    public Activity(int start, int end) {
        this.start = start;
        this.end = end;
    }
}

class Compare {
    static void compare(Activity arr[], int n) {
        Arrays.sort(arr, new Comparator<Activity>() {
            @Override
            public int compare(Activity o1, Activity o2) {
                return o1.end - o2.end;
            }
        });
    }
}

public class UnsortedActivitySelection {

    public static void main(String[] args) {
        int n = 6;
        Activity arr[] = new Activity[n];
        arr[0] = new Activity(5, 9);
        arr[1] = new Activity(1, 2);
        arr[2] = new Activity(3, 4);
        arr[3] = new Activity(0, 6);
        arr[4] = new Activity(5, 7);
        arr[5] = new Activity(8, 9);

        printMaxActivities(arr, n);
    }

    public static void printMaxActivities(Activity[] arr, int n) {
        Compare obj = new Compare();
        obj.compare(arr, n);

        int i = 0;
        System.out.println("("+arr[i].start+","+arr[i].end+")");
        for (int j = 1; j < n; j++) {
            if(arr[j].start>=arr[i].end){
                System.out.println("("+arr[j].start+","+arr[j].end+")");
                i=j;
            }
        }
    }
}
