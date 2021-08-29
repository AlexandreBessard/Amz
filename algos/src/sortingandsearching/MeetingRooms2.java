package sortingandsearching;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class MeetingRooms2 {
    /*
    Input: intervals = [[0,30],[5,10],[15,20]]
    Output: 2
     */
    public static void main(String[] args) {
        Comparator<String> stringLengthComparator = Comparator.comparingInt(String::length);
        PriorityQueue<String> q = new PriorityQueue<>(stringLengthComparator);
        q.add("Alex");
        q.add("Max");
        q.add("Jeremy");
        while(!q.isEmpty()) {
            System.out.println(q.poll());
        }
        System.out.println();
        int[][] intervals = {
                {0, 30},
                {15, 20},
                {5, 10}
        };
        //Sorted:
        //Input: intervals = [[0,30],[5,10],[15,20]]
        //Expected: 2
        System.out.println(" -> " + minMeetingRooms(intervals));
    }

    public static int minMeetingRooms(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparing(a -> a[0]));
        PriorityQueue<int[]> q = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
        for(int[] interval : intervals) {
            if(!q.isEmpty() && interval[0] >= q.peek()[1]) {
                q.poll();
            }
            q.add(interval);
        }
        return q.size();
    }

}
