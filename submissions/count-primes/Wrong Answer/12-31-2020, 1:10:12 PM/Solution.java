// https://leetcode.com/problems/count-primes

class Solution {
    public int countPrimes(int n) {
        boolean[] primes = new boolean[n];
        for (int i = 2; i * i < n; i++)
            if (!primes[i])
                for (int j = i; i * j < n; j++)
                    primes[i * j] = true;
        
        int count = 0;
        for (boolean p: primes)
            if (!p) count++;
        
        return count;
    }
}