// https://leetcode.com/problems/solving-questions-with-brainpower

// https://leetcode.com/problems/solving-questions-with-brainpower/

class Solution {
    public long mostPoints(int[][] questions) {
        int n = questions.length;
        int dp[] = new int[n];
        for (int i = n - 1; i >= 0; i--) {
            int fIndex = i + questions[i][1] + 1;
            if (fIndex < n) {
                dp[i] = dp[fIndex] + questions[i][0];
            } else {
                dp[i] = questions[i][0];
            }
            
            if (fIndex < n - 1) {
                dp[i] = Math.max(dp[i], dp[i + 1]);
            }
        }
        return dp[0];
    }
}