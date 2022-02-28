// https://leetcode.com/problems/longest-valid-parentheses

class Solution {
    public int longestValidParentheses(String s) {
        int left = 0, right = 0, maxLen = 0;
        for (char c : s.toCharArray()) {
            if (c == '(') {
                left++;
            } else {
                right++;
            }
            if (left == right) {
                maxLen = Math.max(maxLen, 2 * left);
            } else if (right >= left) {
                left = 0;
                right = 0;
            }
        }
        
        left = right = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            char c = s.charAt(i);
            if (c == '(') {
                left++;
            } else {
                right++;
            }
            if (left == right) {
                maxLen = Math.max(maxLen, 2 * left);
            } else if (left >= right) {
                left = 0;
                right = 0;
            }
        }
        return maxLen;
    }
}

class SolutionStack {
    public int longestValidParentheses(String s) {
        return 0;
    }
}