// https://leetcode.com/problems/3sum-closest

class Solution {
    public int threeSumClosest(int[] nums, int target) {
        int diff = Integer.MAX_VALUE, length = nums.length;
        Arrays.sort(nums);
        for (int  i = 0; i < length && diff != 0; i++) {
            int low = i + 1, high = length  - 1;
            while (low < high) {
                int sum = nums[i] + nums[low] + nums[high];
                if (Math.abs(target - sum) < Math.abs(diff)) {
                    diff = target - sum;
                } else if (sum < target) {
                    low++;
                } else {
                    high--;
                }
            }
        }
        return target - diff;
    }
}