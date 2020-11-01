package stariq.algorithms.array;

import java.util.*;

// https://leetcode.com/problems/merge-intervals/
// Merge intervals from a 2d array if they overlap.
public class MergeIntervals {

    public static void main(String[] args) {
        int[][] array = new int[][] {{1,3},{2,6},{8,10},{15,18}};

        for(int[] i : mergeWithStack(array)) {
            System.out.println(i[0] + "," + i[1]);
        }
    }

    static class Range {
        int low;
        int high;

        Range(int low, int high) {
            this.low = low;
            this.high = high;
        }
    }

    public static int[][] mergeWithStack(int[][] intervals) {
        if(intervals.length == 0) {
            return new int[0][0]; // Might error
        }

        Arrays.sort(intervals, new Comparator<int[]>() {
            public int compare(int[] a, int[] b) {
                return Integer.compare(a[0], b[0]);
            }
        });

        Stack<Range> ranges = new Stack<>();
        int[] first = intervals[0];
        ranges.push(new Range(first[0], first[1]));

        for(int[] elem : intervals) {
            Range lastRange = ranges.peek();
            Range newRange = new Range(elem[0], elem[1]);
            if(lastRange.high >= newRange.low) {
                lastRange.high = Math.max(lastRange.high, newRange.high);
            } else {
                ranges.push(newRange);
            }
        }

        int[][] result = new int[ranges.size()][2];
        int i = 0;
        for(Range range : ranges) {
            result[i][0] = range.low;
            result[i][1] = range.high;
            i++;
        }
        return result;
    }

    public static int[][] mergeWithDeque(int[][] intervals) {
        if(intervals.length == 0) {
            return new int[0][0]; // Might error
        }

        Arrays.sort(intervals, new Comparator<int[]>() {
            public int compare(int[] a, int[] b) {
                return Integer.compare(a[0], b[0]);
            }
        });

        Deque<Range> ranges = new LinkedList<>();
        int[] first = intervals[0];
        ranges.addLast(new Range(first[0], first[1]));

        for(int[] elem : intervals) {
            Range lastRange = ranges.getLast();
            Range newRange = new Range(elem[0], elem[1]);
            if(lastRange.high >= newRange.low) {
                lastRange.high = Math.max(lastRange.high, newRange.high);
            } else {
                ranges.addLast(newRange);
            }
        }

        int[][] result = new int[ranges.size()][2];
        int i = 0;
        for(Range range : ranges) {
            result[i][0] = range.low;
            result[i][1] = range.high;
            i++;
        }
        return result;
    }
}
