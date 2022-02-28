// https://leetcode.com/problems/evaluate-reverse-polish-notation

class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        
        for (String token : tokens) {
            if (!"+/*-".contains(token)) {
                stack.push(Integer.valueOf(token));
                continue;
            }
            
            int number2 = stack.pop();
            int number1 = stack.pop();
            
            int res = 0;
            
            switch (token) {
                case "+": res = number1 + number2;
                    break;
                case "-": res = number1 = number2;
                    break;
                case "*": res = number1 * number2;
                    break;
                case "/": res = number1 / number2;
                    break;
            }
            stack.push(res);
        }
        return stack.pop();
    }
}