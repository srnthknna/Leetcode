// https://leetcode.com/problems/target-sum

class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int total = Arrays.stream(nums).sum(), n = nums.length, numOfZeros = 0;
        
        for (int num : nums) if (num == 0) numOfZeros++;
        int[][] dp = new int[n + 1][total + 1];
        
        for (int i = 0; i <= n; i++)
            dp[i][0] = 1;
        
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= total; j++) {
                if (nums[i - 1] <= j) {
                    dp[i][j] = dp[i - 1][j] + dp[i - 1][j - nums[i - 1]];
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        
        
        return (int)(Math.pow(2, numOfZeros) * dp[n][(target + total) / 2]);
    }
}