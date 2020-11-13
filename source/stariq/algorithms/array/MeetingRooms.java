package stariq.algorithms.array;

import java.util.Arrays;
import java.util.Comparator;

// https://leetcode.com/problems/meeting-rooms/
public class MeetingRooms {
    public static void main(String[] args) {
        Interval[] intervals = new Interval[] {new Interval(0,30), new Interval(5,10), new Interval(15,20)};
        System.out.println(canAttendMeetings(intervals));
        intervals = new Interval[] {new Interval(7,10), new Interval(2,4)};
        System.out.println(canAttendMeetings(intervals));
    }

    static class Interval {
        int start;
        int end;
        Interval(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

    public static boolean canAttendMeetings(Interval[] intervals) {
        Arrays.sort(intervals, new Comparator<Interval>() {
            @Override
            public int compare(Interval i1, Interval i2) {
                return Integer.compare(i1.start, i2.start);
            }
        });
        Interval first = intervals[0];
        for(int i = 1; i < intervals.length; i++) {
            if(first.end >= intervals[i].start) {
                return false;
            } else {
                first = intervals[i];
            }
        }
        return true;
    }
}
