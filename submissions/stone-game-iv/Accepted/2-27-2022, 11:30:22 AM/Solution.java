// https://leetcode.com/problems/stone-game-iv

// https://www.youtube.com/watch?v=4l5teiw13Jk&list=PLEI-q7w3s9gTJxsvjlI4NxWXtI3-UHUff&index=5&ab_channel=CodingDecoded
// Simulation is the key with dp
// we store the n - moves to revisit if we have already solved the smaller problem before
// if we already computed the smaller problem then return what we know
// if the current moves returns 0 stones left then return true
// else pass the ball to bob and check if alice has more chance to play the game again
// before responding just store the games computation
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
        return dp[n] = aliceWins;
    }
}