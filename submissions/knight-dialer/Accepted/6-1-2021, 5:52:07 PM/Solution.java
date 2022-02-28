// https://leetcode.com/problems/knight-dialer

class Solution {
    int MOD = (int)1e9 + 7;
    public int knightDialer(int n) {
        int[][] map = new int[][]{{4, 6}, {6, 8}, {7, 9}, {4, 8}, {0, 3, 9}, {}, {0, 1, 7}, {2, 6}, {1, 3}, {2, 4}};  
        Integer[][] dp = new Integer[10][n];
        
        int ans = 0;
        
        for(int i = 0; i <= 9; i++){
            ans += memo(i, n - 1, map, dp);
            ans %= MOD;
        }
        
        return ans;
    }
    
    int memo(int i, int n, int[][] map, Integer[][] dp){
        if(n == 0)
            return 1;
        if(dp[i][n] == null){
            int count = 0;
            for(int j : map[i]){
                count += memo(j, n - 1, map, dp);
                count %= MOD;
            }
            dp[i][n] = count;
        }
        
        return dp[i][n];
    }
}