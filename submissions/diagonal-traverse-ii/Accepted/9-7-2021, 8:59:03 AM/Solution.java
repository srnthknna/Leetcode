// https://leetcode.com/problems/diagonal-traverse-ii

class Solution {
    public int[] findDiagonalOrder(List<List<Integer>> nums) {
        int i = 0, n = 0, maxKey = 0;
        Map<Integer, List<Integer>> map = new HashMap<>();
        
        for (int r = nums.size() - 1; r >= 0; r--)
            for (int c = 0; c < nums.get(r).size(); c++) {
                map.putIfAbsent(r + c , new ArrayList<>());
                map.get(r + c).add(nums.get(r).get(c));
                maxKey = Math.max(maxKey, r + c);
                n++;
            }
        int[] ans = new int[n];
        for (int k = 0; k <= maxKey; k++) {
            List<Integer> value = map.get(k);
            if (value == null) continue;
            for (int v : value)
                ans[i++] = v;
        }
        return ans;
    }
}