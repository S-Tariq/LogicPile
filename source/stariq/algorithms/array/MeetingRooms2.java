package stariq.algorithms.array;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

// https://leetcode.com/problems/meeting-rooms-ii/
public class MeetingRooms2 {

    public static void main(String[] args) {
        int[][] array = new int[][] {{0,30}, {5,10}, {15,40}, {30,60}};
        System.out.println(minMeetingRooms(array));
        array = new int[][] {{7,10}, {2,4}};
        System.out.println(minMeetingRooms(array));

        // Uses custom class.
        Interval[] intervals = new Interval[] {new Interval(0,30), new Interval(5,10), new Interval(15,20)};
        System.out.println(minMeetingRooms(intervals));
        intervals = new Interval[] {new Interval(7,10), new Interval(2,4)};
        System.out.println(minMeetingRooms(intervals));
    }

    public static int minMeetingRooms(int[][] intervals) {
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] i1, int[] i2) {
                return Integer.compare(i1[0], i2[0]);
            }
        });
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int[] i : intervals) {
            if(!pq.isEmpty() && pq.peek() <= i[0]) {
                pq.poll();
            }
            pq.add(i[1]);
        }
        return pq.size();
    }

    static class Interval {
        int start;
        int end;
        Interval(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

    public static int minMeetingRooms(Interval[] intervals) {
        Arrays.sort(intervals, new Comparator<Interval>() {
            @Override
            public int compare(Interval i1, Interval i2) {
                return Integer.compare(i1.start, i2.start);
            }
        });
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(Interval i : intervals) {
            if(!pq.isEmpty() && pq.peek() <= i.start) {
                pq.poll();
            }
            pq.add(i.end);
        }
        return pq.size();
    }
}
