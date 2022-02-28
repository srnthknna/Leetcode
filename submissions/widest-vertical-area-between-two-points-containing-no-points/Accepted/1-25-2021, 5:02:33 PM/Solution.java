// https://leetcode.com/problems/widest-vertical-area-between-two-points-containing-no-points

class Solution {
    public int maxWidthOfVerticalArea(int[][] points) {
        List<Integer> x = new ArrayList<>();
        for (int[] point : points) x.add(point[0]);
        Collections.sort(x);
        int max = 0;
        for (int i = 1; i < x.size(); i++) {
            max = Math.max(max, x.get(i) - x.get(i - 1));
        }
        return max;
    }
}