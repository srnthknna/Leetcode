// https://leetcode.com/problems/regular-expression-matching

enum Result {
    TRUE, FALSE
}

class Solution {
    Result[][] memo;
    
    public boolean isMatch(String s, String p) {
        memo = new Result[s.length() + 1][p.length() + 1];
        return dp(0, 0, s, p);
    }
    
    private boolean dp(int i, int j, String s, String p) {
        if (memo[i][j] != null) {
            return memo[i][j] == Result.TRUE;
        }
        
        boolean ans;
        if (j == p.length()) {
            ans = i == s.length();
        } else {
            boolean first_match = (i < s.length() &&
                                  (p.charAt(j) == s.charAt(i) ||
                                  p.charAt(j) == '.'));
             if (j + 1 < p.length() && p.charAt(j + 1) == '*') {
                 ans = (dp(i, j + 2, s, p) || (first_match && dp(i + 1, j, s, p)));
             } else {
                 ans = dp(i + 1, j + 1, s, p);
             }
        }
        
        memo[i][j] = ans ? Result.TRUE : Result.FALSE;
        return ans;
    }
}