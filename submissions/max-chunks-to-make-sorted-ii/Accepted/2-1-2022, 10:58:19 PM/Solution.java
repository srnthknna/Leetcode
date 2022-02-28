// https://leetcode.com/problems/max-chunks-to-make-sorted-ii

class Solution {
    public int maxChunksToSorted(int[] arr) {
        // Stack<Integer> stack = new Stack();
        // int currMax = Integer.MIN_VALUE;
        // for (int i = 0; i < arr.length; i++) {
        //     currMax = stack.isEmpty() ? arr[i] : Math.max(arr[i], stack.peek());
        //     while (!stack.isEmpty() && stack.peek() > arr[i]) stack.pop();
        //     stack.push(currMax);
        // }
        // return stack.size();
        
        int rmin[] = new int[arr.length + 1];
        rmin[arr.length] = Integer.MAX_VALUE;
        for (int i = arr.length - 1; i >= 0; i--)
            rmin[i] = Math.min(arr[i], rmin[i + 1]);
        
        int lmax = Integer.MIN_VALUE, count = 0;
        for (int i = 0; i < arr.length; i++) {
            lmax = Math.max(arr[i], lmax);
            if (lmax <= rmin[i + 1]) count++;
        }
        return count;
    }
     
}