// https://leetcode.com/problems/rank-transform-of-an-array

class Solution {
    public int[] arrayRankTransform(int[] arr) {
        int[] temp = new int[arr.length];
        for (int i = 0; i < arr.length; i++)
            temp[i] = arr[i];
        Arrays.sort(temp);
        Map<Integer, Integer> map = new HashMap<>();
        for (int i : temp) {
            map.putIfAbsent(i, map.size() + 1);
        }
        int[] res = new int[arr.length];
        int i = -1;
        for (int num : arr) {
            res[++i] = map.get(num);
        }
        return res;
    }
}