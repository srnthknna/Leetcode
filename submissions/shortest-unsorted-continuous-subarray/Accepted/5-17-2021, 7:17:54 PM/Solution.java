// https://leetcode.com/problems/shortest-unsorted-continuous-subarray

class Solution {
    public int findUnsortedSubarray(int[] nums) {
        int n = nums.length, left = n, right = 0;
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && nums[stack.peek()] > nums[i]) {
                left = Math.min(left, stack.pop());
            }
            stack.push(i);
        }
        
        
        stack = new Stack<>();
        for (int i = n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && nums[stack.peek()] < nums[i]) {
                right = Math.max(right, stack.pop());
            }
            stack.push(i);
        }
        
        return right - left > 0 ? right - left + 1 : 0;
    }
}