// https://leetcode.com/problems/rank-transform-of-an-array

class Solution {
    public int[] arrayRankTransform(int[] arr) {
        Set<Integer> set = new TreeSet<>();
        for (int i : arr)
            set.add(i);
        Map<Integer, Integer> map = new HashMap<>();
        int rank = 1;
        for (int i : set) {
            map.put(i, rank++);
        }
        int[] res = new int[arr.length];
        int i = 0;
        for (int num : arr) {
            res[i++] = map.get(num);
        }
        return res;
    }
}