// https://leetcode.com/problems/valid-parentheses

class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (c == '{' || c == '[' || c == '(') {
                stack.push(c);
            } else if (c == '}') {
                if (stack.peek() == '{') stack.pop();
            } else if (c == ']') {
                if (stack.peek() == '[') stack.pop();;
            } else if (c == ')')  {
                if (stack.peek() == '(') stack.pop();
            } else {
                stack.push(c);
            }
        }
        return stack.isEmpty();
    }
}