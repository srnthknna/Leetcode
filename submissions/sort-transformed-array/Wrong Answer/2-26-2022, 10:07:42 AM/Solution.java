// https://leetcode.com/problems/sort-transformed-array

// Yes the generic way is to update the array with new values and sorting it
// its O(n) to find new values and O(nlogn) to sort them lets try that first
class Solution1 {
    public int[] sortTransformedArray(int[] nums, int a, int b, int c) {
        for (int i = 0; i < nums.length; i++) {
            nums[i] = nums[i] * nums[i] * a + b * nums[i] + c;
        }
        Arrays.sort(nums);
        return nums;
    }
}

// Next will be to use TreeSet to store the values in the sorted order
class Solution {
    public int[] sortTransformedArray(int[] nums, int a, int b, int c) {
        TreeSet<Integer> vals = new TreeSet<>();
        for (int i = 0; i < nums.length; i++) {
            vals.add(nums[i] * nums[i] * a + b * nums[i] + c);
        }
        int i = 0;
        int[] result = new int[nums.length];
        for (int val : vals) {
            result[i++] = val;
        }
        return result;
    }
}