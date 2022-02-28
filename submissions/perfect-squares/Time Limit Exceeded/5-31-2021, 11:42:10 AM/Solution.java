// https://leetcode.com/problems/perfect-squares

class Solution {
    int[] dp;
    public int numSquares(int n) {
        dp = new int[n + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        // bottom case
        dp[0] = 0;
        return solve(n);
    }
    
    private int solve(int n) {
        if (n <= 3) return n;
        int ans = n;
        for (int i = 1; i * i <= n; i++) {
            int nextInt = n - (i * i);
            if (dp[nextInt] != Integer.MAX_VALUE)
                ans = Math.min(ans, 1 + dp[nextInt]);
            else
                ans = Math.min(ans, 1 + solve(nextInt));
        }
        return ans;
    }
}