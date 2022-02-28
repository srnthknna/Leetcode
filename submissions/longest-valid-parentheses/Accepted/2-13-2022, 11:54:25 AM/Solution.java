// https://leetcode.com/problems/longest-valid-parentheses

class SolutionOOneSpace {
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

class Solution {
    public int longestValidParentheses(String s) {
        Stack<Integer> stack = new Stack<>();
        int maxLen = 0;
        stack.push(-1);
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(')
                stack.push(i);
            else {
                stack.pop();
                if (stack.empty()) {
                    stack.push(i);
                } else {
                    maxLen = Math.max(maxLen, i - stack.peek());
                }
            }
        }
        return maxLen;
    }
}