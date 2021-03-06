// https://leetcode.com/problems/stone-game-iv

class Solution {
    Boolean[] dp = new Boolean[100000 + 1];
    public boolean winnerSquareGame(int n) {
        if (dp[n] != null) {
            return dp[n];
        }
        
        boolean aliceWins = false;
        for (int move = 1; n >= move * move; move++) {
            if (n - move * move == 0) {
                aliceWins = true;
                break;
            } else {
                aliceWins = aliceWins || !winnerSquareGame(n - move * move);
            }
        }
        return aliceWins;
    }
}