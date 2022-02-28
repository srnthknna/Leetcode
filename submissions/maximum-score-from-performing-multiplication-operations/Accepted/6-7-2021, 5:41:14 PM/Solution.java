// https://leetcode.com/problems/maximum-score-from-performing-multiplication-operations

class Solution {
    
    int dp[][];
    int nums[];
    int multipliers[];
    private int helper(int m, int s) {
        if (m == multipliers.length) return 0;
        if (dp[m][s] != -1) 
            return dp[m][s];
        int e = nums.length - (m - s) - 1;
        int option1 = multipliers[m] * nums[s] + helper(m + 1, s + 1);
        int option2 = multipliers[m] * nums[e] + helper(m + 1, s);
        dp[m][s] = Math.max(option1, option2);
        return dp[m][s];
    }
    
    public int maximumScore(int[] nums, int[] multipliers) {
        this.dp = new int[multipliers.length][multipliers.length];
        this.nums = nums;
        this.multipliers = multipliers;
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
        return helper(0, 0);
    }
}