// https://leetcode.com/problems/count-number-of-teams

class Solution {
    public int numTeams(int[] A) {
        int n = A.length;
        int count = 0;
        int[] dp = new int[n];
        int[] dp1 = new int[n];
        
        
        Arrays.fill(dp, 0);
        Arrays.fill(dp1, 0);
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (A[i] < A[j]) {
                    dp[i] = dp[i] + 1;
                    count += dp[j];
                }
                
                if (A[i] > A[j]) {
                    dp1[i] = dp[i] + 1;
                    count += dp1[j];
                }
            }
        }
        return count;
    }
}