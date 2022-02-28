// https://leetcode.com/problems/check-if-it-is-a-straight-line

class Solution {
    public boolean checkStraightLine(int[][] coordinates) {
        int dx = (coordinates[1][0] - coordinates[0][0]);
        int dy = (coordinates[1][1] - coordinates[0][1]);
        for (int i = 2; i < coordinates.length; i++) {
            if (dy * (coordinates[i][0] - coordinates[i - 1][0]) != dx * (coordinates[i][1] - coordinates[i - 1][1])) return false;
        }
        return true;
    }
}