// https://leetcode.com/problems/generate-parentheses

class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        generateParenthesis(ans, n, "", 0, 0);
        return ans;
    }
    
    private void generateParenthesis(List<String> ans, int max, String cur, int open, int close) {
        if (cur.length() == max * 2) {
            ans.add(cur);
            return;
        }
        
        if (open < max) {
            generateParenthesis(ans, max, cur + "(", open + 1, close);
        }
        
        if (close < open) {
            generateParenthesis(ans, max, cur + ")", open, close + 1);
        }
    }
}