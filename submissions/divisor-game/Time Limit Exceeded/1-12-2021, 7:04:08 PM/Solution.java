// https://leetcode.com/problems/divisor-game

class Solution {
    public boolean divisorGame(int N) {
        Boolean[] cache = new Boolean[N + 1];
        return helper(N, cache);
    }
    
    private boolean helper(int N, Boolean[] cache) {
        if (N <= 1) return false;
        if (cache[N] != null) return cache[N];
        for (int x = 1; x <= N / 2; x++) {
            if (N % x == 0) {
              if (!divisorGame(N - x)) {
                    cache[N] = true;
                    return true;
                }
            }
        }
        cache[N] = false;
        return false;
    }
}