// https://leetcode.com/problems/merge-intervals

class Solution {
    public int[][] merge(int[][] intervals) {
        if (intervals.length <= 1)
			return intervals;
        
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        
        List<int[]> merged = new ArrayList<>();
        int[] newInterval = intervals[0];
        merged.add(intervals[0]);
        
        for (int[] interval : intervals) {
            if (newInterval[1] < interval[0]) {
                newInterval = interval;
                merged.add(interval);
            }
            else {
                newInterval[1] = Math.max(newInterval[1], interval[1]);
            }
        }
        return merged.toArray(new int[merged.size()][]);
    }
}