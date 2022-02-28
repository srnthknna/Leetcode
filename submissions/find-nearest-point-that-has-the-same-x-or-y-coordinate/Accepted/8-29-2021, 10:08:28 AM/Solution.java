// https://leetcode.com/problems/find-nearest-point-that-has-the-same-x-or-y-coordinate

class Solution {
    public int nearestValidPoint(int x, int y, int[][] points) {
        int index = -1;
        int smallest = Integer.MAX_VALUE;
        for (int i = 0; i < points.length; i++) {
            if(x == points[i][0] || y == points[i][1]) {
                int tmpDistance = Math.abs(x- points[i][0]) + Math.abs(y - points[i][1]);
                if (tmpDistance < smallest) {
                    smallest = tmpDistance;
                    index = i;
                }
            }
        }
        return index;
    }
}