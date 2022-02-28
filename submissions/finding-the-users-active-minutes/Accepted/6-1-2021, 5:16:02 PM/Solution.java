// https://leetcode.com/problems/finding-the-users-active-minutes

class Solution {
    public int[] findingUsersActiveMinutes(int[][] logs, int k) {
        Map<Integer, Set<Integer>> map = new HashMap<>();
        for (int[] log : logs) {
            if (!map.containsKey(log[0])) map.put(log[0], new HashSet<>());
            map.get(log[0]).add(log[1]);
        }
        int[] result = new int[k];
        for (int key : map.keySet())
            result[map.get(key).size() - 1]++;
        return result;
    }
}