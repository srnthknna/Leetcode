// https://leetcode.com/problems/remove-k-digits

class Solution {
    public String removeKdigits(String num, int k) {
        Stack<Character> stack = new Stack<>();
        for (char digit : num.toCharArray()) {
            while (stack.size() > 0 && k > 0 && stack.peek() > digit) {
                stack.pop();
                k--;
            }
            stack.push(digit);
        }
        
        for (int i = 0; i < k; i++) {
            stack.pop();
        }
        
        
        StringBuilder sb = new StringBuilder();
        boolean leadingZero = true;
        for (char digit : stack) {
            if (leadingZero && digit == '0') continue;
            leadingZero = false;
            sb.append(digit);
        }
        
        return sb.length() == 0 ? "0" : sb.toString();
    }
}