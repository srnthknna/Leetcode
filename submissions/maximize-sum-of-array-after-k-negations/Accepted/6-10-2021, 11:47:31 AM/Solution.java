// https://leetcode.com/problems/maximize-sum-of-array-after-k-negations

class Solution {
    public int largestSumAfterKNegations(int[] nums, int k) {
        Arrays.sort(nums);
        int sum = 0, len = nums.length, minIndex = 0;
        while (k > 0) {
            nums[minIndex] *= -1;
            k--;
            if (minIndex + 1 < len && nums[minIndex] > nums[minIndex + 1]) minIndex++;
        }
        
        for (int i : nums) sum += i;
        
        return sum;
    }
}