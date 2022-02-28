// https://leetcode.com/problems/coin-change

class Solution {
    public int coinChange(int[] coins, int amount) {
        int n = coins.length;
        int[][] dp = new int[n + 1][amount + 1];
        for (int i = 0; i <= amount; i++)
            dp[0][i] = Integer.MAX_VALUE;
        for (int i = 0; i <= amount; i++)
            if (i % coins[0] == 0)
                dp[1][i] = i / coins[0];
            else
                dp[0][i] = Integer.MAX_VALUE;
        for (int i = 2; i <= n; i++) {
            for (int j = 1; j <= amount; j++) {
                if (coins[i - 1] <= j) {
                    dp[i][j] = Math.min(dp[i - 1][j], 1 + dp[i][j - coins[i - 1]]);
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return amount != 0 && dp[n][amount] == 0 ? -1 : dp[n][amount];
    }
}