// https://leetcode.com/problems/largest-triangle-area

class Solution {
    public double largestTriangleArea(int[][] points) {
        int n = points.length;
        double res = 0;
        for (int i = 0; i < n - 2; i++) {
            for (int j = i + 1; j < n - 1; j++) {
                for (int k = j + 1; k < n; k++) {
                    res = Math.max(res, 
                         Math.abs((points[j][0]-points[i][0]) * (points[k][1]-points[i][1]) - 
                               (points[k][0]-points[i][0]) * (points[j][1] - points[i][1])));
                }
            }
        }
        return res / 2.0;
    }
}