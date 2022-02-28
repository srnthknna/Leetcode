// https://leetcode.com/problems/distinct-subsequences-ii

class Solution {
    public int distinctSubseqII(String s) {
        long end[] = new long[26], mod = (long)1e9 + 7;
        for (char c : s.toCharArray())
            end[c - 'a'] = Arrays.stream(end).sum() % mod + 1;
        return (int)(Arrays.stream(end).sum() % mod);
    }
}