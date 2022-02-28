// https://leetcode.com/problems/ternary-expression-parser

class Solution {
    public String parseTernary(String expression) {
        Stack<Character> stack = new Stack<>();
        char[] exp = expression.toCharArray();
        for (int i = expression.length() - 1; i >= 0; i--) {
            if (exp[i] == ':') continue;
            if (exp[i] == '?') {
                char condition = exp[--i];
                char a = stack.pop();
                char b = stack.pop();
                if (condition == 'T') {
                    stack.push(a);
                } else {
                    stack.push(b);
                }
            } else {
                stack.push(exp[i]);
            }
        }
        return String.valueOf(stack.pop());
    }
}