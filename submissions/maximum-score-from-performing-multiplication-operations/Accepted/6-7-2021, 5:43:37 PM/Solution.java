// https://leetcode.com/problems/maximum-score-from-performing-multiplication-operations

class Solution {
    
    int dp[][];
    int nums[];
    int multipliers[];
    private int helper(int mIndex, int start) {
        if (mIndex == multipliers.length) return 0;
        
        if (dp[mIndex][start] != -1)  {
            return dp[mIndex][start];
        }
        
        int end = nums.length - (mIndex - start) - 1;
        int option1 = multipliers[mIndex] * nums[start] + helper(mIndex + 1, start + 1);
        int option2 = multipliers[mIndex] * nums[end] + helper(mIndex + 1, start);
        dp[mIndex][start] = Math.max(option1, option2);
        return dp[mIndex][start];
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