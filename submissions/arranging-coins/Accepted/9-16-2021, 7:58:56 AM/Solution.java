// https://leetcode.com/problems/arranging-coins

class Solution {
    public int arrangeCoins(int n) {
        // Own answer simulation
        // int stairs = 0;
        // while (n > 0 && n - (stairs + 1)  > 0) {
        //     stairs++;
        //     n = n - stairs;
        // }
        // return n - stairs == 1 ? stairs + 1 : stairs;
        
        return (int) (Math.sqrt(2 * (long)n + 0.25) - 0.5);
    }
}