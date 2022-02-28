// https://leetcode.com/problems/basic-calculator-ii

class Solution {
    public int calculate(String s) {
        if (s == null || s.isEmpty()) return 0;
        int lastNum = 0, currNum = 0, result = 0;
        int length = s.length();
        char sign = '+';
        
        for (int i = 0; i < s.length(); i++) {
            char currChar = s.charAt(i);
            if (Character.isDigit(currChar)) {
                currNum = currNum * 10 + (currChar - '0');
            }
            
            if (!Character.isDigit(currChar) && !Character.isWhitespace(currChar) || i == length - 1) {
                if (sign == '+' || sign == '-') {
                    result += lastNum;
                    lastNum = (sign == '+') ? currNum : -currNum;
                } else if (sign == '*') {
                    lastNum = lastNum * currNum;
                } else if (sign == '/') {
                    lastNum = lastNum / currNum;
                }
                sign = currChar;
                currNum = 0;
            }
        }
        result += lastNum;
        return result;
    }
}