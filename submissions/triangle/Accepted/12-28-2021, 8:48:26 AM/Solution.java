// https://leetcode.com/problems/triangle

class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        for (int r = 1; r < triangle.size(); r++) {
            for (int c = 0; c <=r ; c++) {
                int smallestAbove = Integer.MAX_VALUE;
                if (c > 0) {
                    smallestAbove = triangle.get(r - 1).get(c - 1);
                }
                if (c < r) {
                    smallestAbove = Math.min(smallestAbove, triangle.get(r - 1).get(c));
                }
                int path = smallestAbove + triangle.get(r).get(c);
                triangle.get(r).set(c, path);
            }
        }
        return Collections.min(triangle.get(triangle.size() - 1));
    }
}