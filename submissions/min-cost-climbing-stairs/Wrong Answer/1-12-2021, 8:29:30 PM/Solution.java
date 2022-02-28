// https://leetcode.com/problems/min-cost-climbing-stairs

class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int[] dp = new int[cost.length + 1];
        dp[0] = 0;
        dp[1] = 1;
        for (int i = 2; i < cost.length; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[cost.length];
    }
}