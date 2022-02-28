// https://leetcode.com/problems/partition-equal-subset-sum

class Solution {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int num : nums)
            sum += num;
        
        if (sum % 2 == 1 || nums.length % 2 == 1) return false;
        
        return subSetSum(nums, sum / 2);
    }
    
    private boolean subSetSum(int[] nums, int sum) {
        boolean[][] dp = new boolean[nums.length + 1][sum + 1];
        
        for (int i = 0; i <= sum; i++)
            dp[0][i] = false;
        for (int i = 0; i <= nums.length; i++)
            dp[i][0] = true;
        
        for (int i = 1; i <= nums.length; i++) {
            for (int j = 1; j <= sum; j++) {
                if (nums[i - 1] <= j) {
                    dp[i][j] = dp[i][j - nums[i - 1]] || dp[i - 1][j];
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[nums.length][sum];
    }
}