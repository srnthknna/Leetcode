// https://leetcode.com/problems/brightest-position-on-street

class Solution {
    public int brightestPosition(int[][] lights) {
        TreeMap<Integer, Integer> map = new TreeMap<Integer, Integer>();
        for (int[] ligth : lights) {
            int s = ligth[0] - ligth[1];
            int e = ligth[0] + ligth[1] + 1;
            map.put(s, map.getOrDefault(s, 0) + 1);
            map.put(e, map.getOrDefault(e, 0) - 1);
        }
        int curr = 0, max = 0, result = 0;
        for (int num : map.keySet()) {
            curr += map.get(num);
            if (curr > max) {
                max = curr;
                result = num;
            }
        }
        return result;
    }
}