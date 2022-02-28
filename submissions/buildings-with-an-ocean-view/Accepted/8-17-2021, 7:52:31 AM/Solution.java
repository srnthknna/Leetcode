// https://leetcode.com/problems/buildings-with-an-ocean-view

class Solution {
    public int[] findBuildings(int[] heights) {
        int last = Integer.MIN_VALUE;
        List<Integer> res = new ArrayList<>();
        for (int i = heights.length - 1; i >= 0; i--) {
            if (heights[i] > last) {
                res.add(i);
                last = heights[i];
            }
        }
        int index= 0;
        int[] ans = new int[res.size()];
        for (int i = res.size() - 1; i >= 0; i--) {
            ans[index++] = res.get(i);
        }
        return ans;
    }
}