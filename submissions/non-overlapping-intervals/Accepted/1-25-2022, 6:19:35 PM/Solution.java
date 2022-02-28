// https://leetcode.com/problems/non-overlapping-intervals

class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        if (intervals.length == 0) return 0;
        
        Arrays.sort(intervals, (a, b) -> (a[1] - b[1]));
        
        int count = 1, end = intervals[0][1];
        
        for (int[] interval : intervals) {
            if (interval[0] >= end) {
                count++;
                end = interval[1];
            }
        }
        return intervals.length - count;
    }
}