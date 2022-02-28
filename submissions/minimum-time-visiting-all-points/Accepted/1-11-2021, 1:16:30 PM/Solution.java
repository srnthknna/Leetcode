// https://leetcode.com/problems/minimum-time-visiting-all-points

class Solution {
    public int minTimeToVisitAllPoints(int[][] points) {
        int steps = 0;
        
        for (int i = 0; i < points.length - 1; i++) {
            int dx = Math.abs(points[i][0] - points[i + 1][0]);
            int dy = Math.abs(points[i][1] - points[i + 1][1]);
            steps += Math.max(dx, dy);
        }
        return steps;
    }
}