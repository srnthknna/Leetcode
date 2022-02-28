// https://leetcode.com/problems/reverse-integer

class Solution {
    public int reverse(int x) {    
        long reverse = 0;
        
        while (Math.abs(x) > 0) {
            reverse = reverse * 10 + x % 10;
            x /= 10;
        }
        
        if (Math.abs(reverse) > Integer.MAX_VALUE) return 0;
        
        return (int) reverse;        
    }
}