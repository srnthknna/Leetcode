// https://leetcode.com/problems/happy-number

class Solution {
    
    private int getNext(int n) {
        int sum = 0;
        while (n > 0) {
            int d = n % 10;
            sum += d * d;
            n /= 10;
        }
        return sum;
    }
    
    public boolean isHappy(int n) {
        int slow = n, fast = getNext(n);
        while(fast != 1 && fast != slow) {
            slow = getNext(slow);
            fast = getNext(slow);
        }
        
        return fast == 1;
    }
}