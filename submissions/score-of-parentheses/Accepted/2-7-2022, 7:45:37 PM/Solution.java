// https://leetcode.com/problems/score-of-parentheses

class Solution {
    //https://www.youtube.com/watch?v=jfmJusJ0qKM&list=WL&index=2&ab_channel=NickWhite O N space
    public int scoreOfParenthesesONSpace(String s) {
        Stack<Integer> stack = new Stack<>();
        int score = 0;
        
        for (char c : s.toCharArray()) {
            if (c == '(') {
                stack.push(score);
                score = 0;
            } else {
                score = stack.pop() + Math.max(score * 2, 1);
            }
        }
        
        return score;
    }
    
    public int scoreOfParentheses(String s) {
        int score = 0, bal = 0;
        
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                bal++;
            } else {
                bal--;
                if (s.charAt(i - 1) == '(')
                    score += 1 << bal;
            }
        }
        
        return score;
    }
}