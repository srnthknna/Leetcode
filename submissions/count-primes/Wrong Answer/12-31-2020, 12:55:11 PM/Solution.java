// https://leetcode.com/problems/count-primes

class Solution {
    public int countPrimes(int n) {
        int twoMults = 1, count = 0;
        if (n <= 2) return 0;
        while (twoMults - 1 <= n) {
            count++;
            twoMults *= 2;
        }
        return count;
    }
}