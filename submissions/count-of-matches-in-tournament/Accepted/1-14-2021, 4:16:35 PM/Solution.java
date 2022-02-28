// https://leetcode.com/problems/count-of-matches-in-tournament

class Solution {
    public int numberOfMatches(int n) {
        if (n <= 1) return 0;
        if (n % 2 == 0) {
            n /= 2;
            return n + numberOfMatches(n);
        }
        else {
            n = (n - 1) / 2;
            return n + numberOfMatches(n + 1);
        }
    }
}