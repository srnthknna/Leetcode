// https://leetcode.com/problems/divisor-game

class Solution {
    public boolean divisorGame(int N) {
        if (N <= 0) return false;
        
        for (int x = 1; x <= N / 2; x++) {
            if (N % x == 0) {
                if (!divisorGame(N - x)) {
                    return true;
                }
            }
        }
        
        return false;
    }
}