// https://leetcode.com/problems/valid-boomerang

class Solution {
    public boolean isBoomerang(int[][] points) {
        // K_AB = (p[0][0] - p[1][0]) / (p[0][1] - p[1][1])
        // K_AC = (p[0][0] - p[2][0]) / (p[0][1] - p[2][1])
        return (points[0][0] - points[1][0]) * (points[0][1] - points[2][1]) != (points[0][0] - points[2][0]) * (points[0][1] - points[1][1]);
    }
}