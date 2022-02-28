// https://leetcode.com/problems/unique-paths

class Solution {
    Map<String, Integer> map = new HashMap<>();
    public int uniquePaths(int m, int n) {
        if (m == 1 || n == 1) return 1;
        if (m == 0 || n == 0) return 0;
        int down = 0, right = 0;
        String downKey = m - 1 + "," + n, rightKey = m + "," + (n - 1);
        if (map.containsKey(downKey)) {
            down = map.get(downKey);
        } else {
            down = uniquePaths(m - 1, n);
            map.put(downKey, down);
        }
        
        if (map.containsKey(rightKey)) {
            right = map.get(rightKey);
        } else {
            right = uniquePaths(m, n - 1);
            map.put(rightKey, right);
        }
        return down + right;
    }
}