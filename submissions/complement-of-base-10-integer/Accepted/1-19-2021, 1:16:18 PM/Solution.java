// https://leetcode.com/problems/complement-of-base-10-integer

class Solution {
    public int bitwiseComplement(int N) {
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