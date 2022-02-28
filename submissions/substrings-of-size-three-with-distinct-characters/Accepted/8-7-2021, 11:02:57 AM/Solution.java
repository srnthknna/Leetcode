// https://leetcode.com/problems/substrings-of-size-three-with-distinct-characters

class Solution {
    public int countGoodSubstrings(String s) {
        int ans = 0;
        for (int i = 0; i < s.length() - 2; i++) {
            char a = s.charAt(i);
            char b = s.charAt(i + 1);
            char c = s.charAt(i + 2);
            if (a != b && a != c && b != c)
                ans++;
        }
        return ans;
    }
}