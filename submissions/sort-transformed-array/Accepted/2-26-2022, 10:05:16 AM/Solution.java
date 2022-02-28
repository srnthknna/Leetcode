// https://leetcode.com/problems/sort-transformed-array

// Yes the generic way is to update the array with new values and sorting it
// its O(n) to find new values and O(nlogn) to sort them lets try that first
class Solution {
    public int[] sortTransformedArray(int[] nums, int a, int b, int c) {
        for (int i = 0; i < nums.length; i++) {
            nums[i] = nums[i] * nums[i] * a + b * nums[i] + c;
        }
        Arrays.sort(nums);
        return nums;
    }
}