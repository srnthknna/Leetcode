// https://leetcode.com/problems/longest-palindrome

class Solution {
    public int longestPalindrome(String s) {
        int[] count = new int[128];
        for (char c: s.toCharArray())
            count[c]++;

        int ans = 0;
        for (int v: count) {
            ans += v / 2 * 2; // int / 2 if value is 1 is 0 so single no of 1 is only counted in if case
            if (ans % 2 == 0 && v % 2 == 1) ans++;
        }
        return ans;
    }
}