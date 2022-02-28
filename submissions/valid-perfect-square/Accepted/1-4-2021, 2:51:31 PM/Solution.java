// https://leetcode.com/problems/valid-perfect-square

class Solution {
    public boolean isPerfectSquare(int num) {
        if (num < 2) return true;
        
        long left = 2, right = num / 2, guessSquare, pivot;
        
        while (left <= right) {
            pivot = left + (right - left) / 2;
            guessSquare = pivot * pivot;
            if (guessSquare == num) return true;
            else if (guessSquare > num) right = pivot - 1;
            else left = pivot + 1;
        }
        
        return false;
    }
}