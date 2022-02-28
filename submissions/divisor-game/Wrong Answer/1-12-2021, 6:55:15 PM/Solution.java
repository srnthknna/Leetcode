// https://leetcode.com/problems/divisor-game

class Solution {
    public boolean divisorGame(int N) {
        if (N <= 1) return false;
        
        for (int x = 1; x <= N; x++) {
            if (N % x == 0) {
                if (!divisorGame(N - x)) {
                    return true;
                }
            }
        }
        
        return false;
    }
}