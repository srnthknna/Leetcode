// https://leetcode.com/problems/palindrome-number

class Solution {
    public boolean isPalindrome(int x) {
        if (x < 0 || x % 10 == 0  && x != 0) return false;
        
        int rev = 0;
        
        while (x > 0) {
            rev = rev * 10 + x % 10;
            x /= 10;
        }
        
       return x == rev;
    }
}