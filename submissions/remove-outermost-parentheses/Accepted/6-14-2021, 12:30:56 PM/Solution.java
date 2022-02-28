// https://leetcode.com/problems/remove-outermost-parentheses

class Solution {
    public String removeOuterParentheses(String s) {
        StringBuilder sb = new StringBuilder();
        int count = 0;
        for (char c : s.toCharArray()) {
            if (c == '(' && count++ != 0)
                sb.append("(");
            else if (c == ')' && --count != 0)
                sb.append(")");
        }
        return sb.toString();
    }
}