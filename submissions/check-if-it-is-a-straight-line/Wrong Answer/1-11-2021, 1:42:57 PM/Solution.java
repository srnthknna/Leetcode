// https://leetcode.com/problems/check-if-it-is-a-straight-line

class Solution {
    public boolean checkStraightLine(int[][] coordinates) {
        double diff = (coordinates[0][0] - coordinates[1][0])/(coordinates[0][1] - coordinates[1][1]);
        for (int i = 2; i < coordinates.length; i++) {
            if ((coordinates[i][0] - coordinates[i - 1][0])/(coordinates[i][1] - coordinates[i - 1][1]) != diff) return false;
        }
        return true;
    }
}