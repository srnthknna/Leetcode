// https://leetcode.com/problems/maximum-nesting-depth-of-the-parentheses

class Solution {
    public int maxDepth(String s) {
        int left = 0, right = 0, max = Integer.MIN_VALUE;
        for (char c : s.toCharArray()) {
            if (c == '(') left++;
            else if (c == ')') right++;
            max = Math.max(max, left - right);
        }
        return max;
    }
}