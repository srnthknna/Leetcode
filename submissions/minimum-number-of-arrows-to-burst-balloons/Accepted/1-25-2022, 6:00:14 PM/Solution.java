// https://leetcode.com/problems/minimum-number-of-arrows-to-burst-balloons

class Solution {
    public int findMinArrowShots(int[][] points) {
        if (points.length == 0) return 0;
        Arrays.sort(points, (p1, p2) -> {
            if (p1[1] == p2[1]) return 0;
            if (p1[1] < p2[1]) return -1;
            return 1;
        });
        
        int arrow = 1;
        int start, end, firstEnd = points[0][1];
        for (int[] p : points) {
            if (firstEnd < p[0]) {
                arrow++;
                firstEnd = p[1];
            }
        }
        return arrow;
    }
}