// https://leetcode.com/problems/number-complement

class Solution {
    public int findComplement(int N) {
        int looper = N, bit = 1;
        if (N == 0) return 1;
        while (looper != 0) {
            N ^= bit;
            bit <<= 1;
            looper >>= 1;
        } 
        return N;
    }
}