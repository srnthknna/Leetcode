// https://leetcode.com/problems/maximum-score-from-performing-multiplication-operations

class Solution {
    
    int dp[][];
    private int helper(int m, int[] multipliers, int[] nums, int s, int[][] dp) {
        if (m == multipliers.length) return 0;
        if (dp[m][s] != -1) 
            return dp[m][s];
        int e = nums.length - (m - s) - 1;
        int option1 = multipliers[m] * nums[s] + helper(m + 1, multipliers, nums, s + 1, dp);
        int option2 = multipliers[m] * nums[e] + helper(m + 1, multipliers, nums, s, dp);
        dp[m][s] = Math.max(option1, option2);
        return dp[m][s];
    }
    
    public int maximumScore(int[] nums, int[] multipliers) {
        int dp[][] = new int[1000][1000];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
        return helper(0, multipliers, nums, 0, dp);
    }
}