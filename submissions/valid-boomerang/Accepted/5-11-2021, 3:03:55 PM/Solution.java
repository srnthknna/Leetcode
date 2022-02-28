// https://leetcode.com/problems/valid-boomerang

class Solution {
    public boolean isBoomerang(int[][] p) {
        // K_AB = (p[0][0] - p[1][0]) / (p[0][1] - p[1][1])
        // K_AC = (p[0][0] - p[2][0]) / (p[0][1] - p[2][1])
        return (p[0][0] - p[1][0]) * (p[0][1] - p[2][1]) != (p[0][0] - p[2][0]) * (p[0][1] - p[1][1]);
    }
}