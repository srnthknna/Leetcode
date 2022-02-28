// https://leetcode.com/problems/two-sum-ii-input-array-is-sorted

class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int[] ret = new int[] {-1, -1};
        if (numbers == null || numbers.length == 0) return ret;
        int l = 0, r = numbers.length - 1;
        while (l < r) {
            int sum = numbers[l] + numbers[r];
            if (sum == target) {
                ret[0] = l + 1;
                ret[1] = r + 1;
                return ret;
            } else if (sum < target) {
                l++;
            } else if (sum > target) {
                r--;
            }
        }
        return ret;
    }
}