// https://leetcode.com/problems/knight-dialer

class Solution {
    int MOD = (int)1e9 + 7;
    int[][] map = new int[][]{{4, 6}, {6, 8}, {7, 9}, {4, 8}, {0, 3, 9}, {}, {0, 1, 7}, {2, 6}, {1, 3}, {2, 4}}; 
    Integer[][] dp;
    public int knightDialer(int n) { 
        //dp = new Integer[10][n];
        int ans = 0;
        
        for (int i = 0; i < 10; i++) {
            ans += memo(n - 1, i);
            ans %= MOD;
        }
        return ans;
    }
    
    private int memo (int n, int i) {
        if (n == 0) return 1;
        //if (dp[i][n] == null) {
            int count = 0;
            for (int j : map[i]) {
                count += memo(n - 1, j);
                count %= MOD;
            }
        //    dp[i][n] = count;
       // }
        return count;
    }
}