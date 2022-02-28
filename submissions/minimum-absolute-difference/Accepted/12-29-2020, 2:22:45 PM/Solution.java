// https://leetcode.com/problems/minimum-absolute-difference

class Solution {
    public List<List<Integer>> minimumAbsDifference(int[] arr) {
        List<List<Integer>> ret = new ArrayList<>();
        int diff = Integer.MAX_VALUE;
        Arrays.sort(arr);
        for (int i = 1; i < arr.length; i++) {
            diff = Math.min(arr[i] - arr[i - 1], diff);
        }
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] - arr[i - 1] == diff) {
                final List<Integer> internalList = new ArrayList<>();
                internalList.add(arr[i - 1]);
                internalList.add(arr[i]);
                ret.add(internalList);
            }
        }
        return ret;
    }
}