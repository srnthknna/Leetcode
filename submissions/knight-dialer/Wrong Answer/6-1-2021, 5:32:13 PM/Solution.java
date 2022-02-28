// https://leetcode.com/problems/knight-dialer

class Solution {
    public int knightDialer(int n) {
        int[][] map = new int[][]{{4, 6}, {6, 8}, {7, 9}, {4, 8}, {0, 3, 9}, {}, {0, 1, 7}, {2, 6}, {1, 3}, {2, 4}};
        int[] dp = new int[10], next = new int[10];
        Arrays.fill(dp, 1);
        
        for (int loop = 0; loop < n - 1; loop++) {
            Arrays.fill(next, 0);
            for (int i = 0; i < 10; i++) {
                for (int j : map[i]) {
                    next[j] += dp[j];
                }
            }
            dp = Arrays.copyOf(next, next.length);
        }
        
        int sum = 0;
        for (int i : dp) sum += i % (10 ^ 9 + 7);
        
        return sum;
    }
}