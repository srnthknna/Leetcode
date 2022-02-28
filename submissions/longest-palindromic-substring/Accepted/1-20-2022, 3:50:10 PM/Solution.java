// https://leetcode.com/problems/longest-palindromic-substring

class Solution {
    public String longestPalindrome(String s) {
        boolean[][] dp = new boolean[s.length()][s.length()];
        String res = null;
        int n = s.length();
        
        for (int i = n - 1; i >= 0; i--) {
            for (int j = i; j < n; j++) {
                dp[i][j] = s.charAt(i) == s.charAt(j) && (j - i + 1 < 3 || dp[i + 1][j - 1]);
                
                if (dp[i][j] && (res == null || j - i + 1 > res.length()))
                    res = s.substring(i, j + 1);
            }
        }
        
        return res;
    }
}