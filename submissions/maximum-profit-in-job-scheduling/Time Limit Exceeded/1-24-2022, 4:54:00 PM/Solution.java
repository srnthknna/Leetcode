// https://leetcode.com/problems/maximum-profit-in-job-scheduling

class Solution {
    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        int[][] scheduled = new int[startTime.length][3];
        for (int i = 0; i < scheduled.length; i++) {
            scheduled[i][0] = startTime[i];
            scheduled[i][1] = endTime[i];
            scheduled[i][2] = profit[i];
        }
        Arrays.sort(scheduled, (a, b) -> (a[0] - b[0]));
        return helper(scheduled, 0, 0);
    }
    
    private int helper(int[][] scheduled, int end, int index) {
        if (index >= scheduled.length) return 0;
        if (scheduled[index][0] < end) {
            return helper(scheduled, end, index + 1);
        }
        return Math.max(scheduled[index][2] + helper(scheduled, scheduled[index][1], index + 1), helper(scheduled, end, index + 1));
    }
}