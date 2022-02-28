// https://leetcode.com/problems/string-to-integer-atoi

class Solution {
    public int myAtoi(String s) {
        int sign = 1, total = 0, index = 0, n = s.length();
        
        // skip white space
        while (index < n && s.charAt(index) == ' ')
            index++;
        
        // capture sign
        if (index < n && s.charAt(index) == '+' || s.charAt(index) == '-')
            sign = s.charAt(index++) == '+' ? 1 : -1;
        
        // parse the chars
        while (index < n) {
            int digit = s.charAt(index) - '0';
            // break if we encounter non digit
            if (digit < 0 || digit > 9) break;
            // check overflow
            if (total > Integer.MAX_VALUE / 10 || total == Integer.MAX_VALUE / 10 && digit < Integer.MAX_VALUE % 10)
                return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            
            total = total * 10 + digit;
            index++;
        }
        return total * sign;
    }
}