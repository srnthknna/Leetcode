// https://leetcode.com/problems/sliding-window-maximum

class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || nums.length == 0) return new int[0];
        int n = nums.length, ri = 0;
        if (n * k == 0) return new int[0];
        
        ArrayDeque<Integer> dequeue = new ArrayDeque<>();
        int[] result = new int[n - k + 1];
        for (int i = 0; i < n; i++) {
            while (!dequeue.isEmpty() && dequeue.peek() == i - k) dequeue.pollFirst();
            
            while (!dequeue.isEmpty() && nums[dequeue.peekLast()] <= nums[i]) dequeue.pollLast();
            
            dequeue.offer(i);
            
            if (i >= k - 1) {
                result[ri++] = nums[dequeue.peekFirst()];
            }
        }
        return result;
    }
}