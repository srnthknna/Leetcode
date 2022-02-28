// https://leetcode.com/problems/minimum-absolute-difference

class Solution {
    public List<List<Integer>> minimumAbsDifference(int[] arr) {
        List<List<Integer>> ret = new ArrayList<>();
        int diff = Integer.MAX_VALUE;
        Arrays.sort(arr);
        for (int i = 0 ; i < arr.length - 1; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                final int first = arr[i];
                final int second = arr[j];
                final List<Integer> internalList = new ArrayList<>();
                internalList.add(first);
                internalList.add(second);
                if (Math.abs(first - second) < diff) {
                    diff = Math.abs(first - second);
                    ret.clear();
                    ret.add(internalList);
                } else if (Math.abs(first - second) == diff) {
                    ret.add(internalList);
                }
            }
        }
        return ret;
    }
}