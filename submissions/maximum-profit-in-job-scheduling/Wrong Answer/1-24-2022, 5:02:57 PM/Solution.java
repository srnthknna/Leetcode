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
        Integer[] dp = new Integer[scheduled.length];
        return helper(scheduled, 0, 0, dp);
    }
    
    private int helper(int[][] scheduled, int end, int index, Integer[] dp) {
        if (index >= scheduled.length) return 0;
        
        if (dp[index] != null) {
            return dp[index];
        }
        
        if (scheduled[index][0] < end) {
            return helper(scheduled, end, index + 1, dp);
        }
    
        return dp[index] = Math.max(scheduled[index][2] + helper(scheduled, scheduled[index][1], index + 1, dp), helper(scheduled, end, index + 1, dp));
    }
}