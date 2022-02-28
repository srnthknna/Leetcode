// https://leetcode.com/problems/minimum-number-of-swaps-to-make-the-string-balanced

class Solution {
    public int minSwaps(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '[') stack.push('[');
            else if (!stack.empty() && s.charAt(i) == ']' && stack.peek() == '[') stack.pop();
        }
        return (stack.size() + 1) / 2;
    }
}