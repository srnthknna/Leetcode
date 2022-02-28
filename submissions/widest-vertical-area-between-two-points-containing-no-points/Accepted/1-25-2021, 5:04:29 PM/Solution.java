// https://leetcode.com/problems/widest-vertical-area-between-two-points-containing-no-points

class Solution {
    public int maxWidthOfVerticalArea(int[][] points) {
        int[] x = new int[points.length];
        int y = 0;
        for (int[] point : points) x[y++] = point[0];
        Arrays.sort(x);
        int max = 0;
        for (int i = 1; i < x.length; i++) {
            max = Math.max(max, x[i] - x[i - 1]);
        }
        return max;
    }
}