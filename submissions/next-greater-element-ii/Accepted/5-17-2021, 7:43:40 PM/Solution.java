// https://leetcode.com/problems/next-greater-element-ii

class Solution {
    public int[] nextGreaterElements(int[] nums) {
        Deque<Integer> stack = new ArrayDeque<>();
        int[] res = new int[nums.length];
        Arrays.fill(res, -1);
        int n = nums.length;
        
        for (int i = 0; i < 2 * n; i++) {
            while (!stack.isEmpty() && nums[stack.peek()] < nums[i % n]) {
                res[stack.pop()] = nums[i % n];
            }
            stack.push(i % n);
        }
        return res;
    }
}