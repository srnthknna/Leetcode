// https://leetcode.com/problems/max-chunks-to-make-sorted-ii

class Solution {
    public int maxChunksToSorted(int[] arr) {
        Stack<Integer> stack = new Stack();
        int currMax = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            currMax = stack.isEmpty() ? arr[i] : Math.max(arr[i], stack.peek());
            while (!stack.isEmpty() && stack.peek() > arr[i]) stack.pop();
            stack.push(currMax);
        }
        return stack.size();
    }
}