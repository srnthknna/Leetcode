// https://leetcode.com/problems/partition-equal-subset-sum

class Solution {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int num : nums)
            sum += num;
        
        if (sum % 2 != 0 || nums.length % 2 != 0) return false;
        
        return subSetSum(nums, sum / 2);
    }
    
    private boolean subSetSum(int[] nums, int sum) {
        int n = nums.length;
        boolean[][] dp = new boolean[n + 1][sum + 1];
        
        for (int i = 0; i <= sum; i++)
            dp[0][i] = false;
        for (int i = 0; i <= n; i++)
            dp[i][0] = true;
        
        for (int i = 1; i <= n; i++) {
            int curr = nums[i - 1];
            for (int j = 1; j <= sum; j++) {
                if (curr > j) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = dp[i - 1][j] || dp[i - 1][j - curr];
                }
            }
        }
        return dp[n][sum];
    }
}