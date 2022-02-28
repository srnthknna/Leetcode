// https://leetcode.com/problems/k-radius-subarray-averages

class Solution {
    public int[] getAverages(int[] nums, int k) {
        int left = 0, sum = 0, size = 0;
        int[] result = new int[nums.length];
        Arrays.fill(result, -1);
        for (int right = 0; right < nums.length; right++) {
            sum += nums[right];
            
            size = right - left + 1;
            if (size == 2 * k + 1) {
                int average = sum / size;
                result[(size / 2) + left] = average;
                sum -= nums[left++];
            }
        }
        return result;
    }
}