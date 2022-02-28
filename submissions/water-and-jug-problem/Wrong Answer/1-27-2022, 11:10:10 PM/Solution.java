// https://leetcode.com/problems/water-and-jug-problem

class Solution {
    public boolean canMeasureWater(int x, int y, int z) {
        if (x + y < z) return false;
        if (x + y == z | x == z || y == z) return true;
        return z % gcd(x, y) == 0;
    }
    
    private int gcd(int x, int y) {
        if (y == 0) return x;
        return gcd(y, y % x);
    }
}