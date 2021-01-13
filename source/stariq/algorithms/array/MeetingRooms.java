package stariq.algorithms.array;

import java.util.Arrays;
import java.util.Comparator;

// Question in data
// https://leetcode.com/problems/meeting-rooms/
public class MeetingRooms {
    public static void main(String[] args) {
        int[][] array = new int[][] {{0,30}, {5,10}, {15,20}};
        System.out.println(canAttendMeetings(array));
        array = new int[][] {{7,10}, {2,4}};
        System.out.println(canAttendMeetings(array));

        // Uses custom class.
        Interval[] intervals = new Interval[] {new Interval(0,30), new Interval(5,10), new Interval(15,20)};
        System.out.println(canAttendMeetings(intervals));
        intervals = new Interval[] {new Interval(7,10), new Interval(2,4)};
        System.out.println(canAttendMeetings(intervals));
    }

    // Uses 2d array.
    public static boolean canAttendMeetings(int[][] intervals) {
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] i1, int[] i2) {
                return Integer.compare(i1[0], i2[0]);
            }
        });
        for(int i = 0; i < intervals.length - 1; i++) {
            if(intervals[i][1] > intervals[i + 1][0]) {
                return false;
            }
        }
        return true;
    }

    static class Interval {
        int start;
        int end;
        Interval(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

    // Uses custom class in 1d array.
    public static boolean canAttendMeetings(Interval[] intervals) {
        Arrays.sort(intervals, new Comparator<Interval>() {
            @Override
            public int compare(Interval i1, Interval i2) {
                return Integer.compare(i1.start, i2.start);
            }
        });
        for(int i = 0; i < intervals.length - 1; i++) {
            if(intervals[i].end > intervals[i + 1].start) {
                return false;
            }
        }
        return true;
    }
}
