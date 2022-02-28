// https://leetcode.com/problems/house-robber

class Solution {
    public int rob(int[] nums) {
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        dp[1] = nums[1];
        for (int i = 2; i < nums.length; i++) {
            dp[i] = nums[i] + dp[i - 2];
        }
        return Math.max(dp[nums.length - 1], dp[nums.length - 2]);
    }
}