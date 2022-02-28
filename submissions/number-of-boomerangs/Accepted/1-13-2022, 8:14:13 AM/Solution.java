// https://leetcode.com/problems/number-of-boomerangs

class Solution {
    public int numberOfBoomerangs(int[][] points) {
        int result = 0;
        Map<Integer, Integer> map = new HashMap<>();
        
        for (int[] i : points) {
            for (int[] j : points) {
                if (i == j) continue;
                int dist = (i[0]-j[0])*(i[0]-j[0]) + (i[1]-j[1])*(i[1]-j[1]);
                int prevDist = map.getOrDefault(dist, 0);
                result += prevDist * 2;
                map.put(dist, prevDist + 1);
            }
            map.clear();
        }
        return result;
    }
}