// https://leetcode.com/problems/unique-paths

class Solution {
    Map<String, Integer> map = new HashMap<>();
    public int uniquePaths(int m, int n) {
        if (m == 1 || n == 1) return 1;
        if (m == 0 || n == 0) return 0;
        int down = 0, right = 0;
        String key = m + "," + n;
        if (map.containsKey(key)) {
           return map.get(key);
        } 
        int val = uniquePaths(m - 1, n) + uniquePaths(m, n - 1);
        map.put(key, val);
        return val;
    }
}