// https://leetcode.com/problems/longest-palindromic-substring

class Solution {
    public String longestPalindromeDPTrivial(String s) {
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
    
    public String longestPalindrome(String s) {
        if (s == null || s.length() < 1) return "";
        int start = 0, end = 0;
        
        for (int i = 0; i < s.length(); i++) {
            int len1 = expandAroundMiddle(s, i, i);
            int len2 = expandAroundMiddle(s, i, i + 1);
            
            int len = Math.max(len1, len2);
            if (len > end - start) {
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }
        return s.substring(start, end + 1);
    }
    
    private int expandAroundMiddle(String s, int left, int right) {
        if (s == null || left > right) return 0;
        
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        
        return right - left - 1;
    }
}