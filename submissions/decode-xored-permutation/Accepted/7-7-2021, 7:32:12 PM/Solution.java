// https://leetcode.com/problems/decode-xored-permutation

class Solution {
    public int[] decode(int[] encoded) {
        int n = encoded.length + 1; int first = 0;
        int[] res = new int[n];
        for (int i = 0; i <= n; i++) {
            first ^= i;
            if (i < n && i % 2 == 1) {
                first ^= encoded[i];
            }
        }
        
        res[0] = first;
        for (int i = 0; i < n - 1; i++) {
            res[i + 1] = res[i] ^ encoded[i];
        }
        return res;
        
    }
}