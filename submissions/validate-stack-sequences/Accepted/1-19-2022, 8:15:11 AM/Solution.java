// https://leetcode.com/problems/validate-stack-sequences

class Solution {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        int n = pushed.length, j = 0;
        Stack<Integer> stack = new Stack<>();
        
        for (int x : pushed) {
            stack.push(x);
            while (!stack.isEmpty() && j < n && stack.peek() == popped[j]) {
                j++;
                stack.pop();
            }
        }
        return j == n;
    }
}