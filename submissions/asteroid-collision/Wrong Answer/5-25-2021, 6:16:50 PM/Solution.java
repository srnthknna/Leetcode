// https://leetcode.com/problems/asteroid-collision

class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();
        for (int asteroid : asteroids) {
            if (asteroid > 0) {
                stack.push(asteroid);
            } else {
                while (!stack.isEmpty() && stack.peek() > 0 && stack.peek() <= Math.abs(asteroid)) {
                    stack.pop();
                } 
                if (stack.isEmpty() || stack.peek() < 0) {
                    stack.push(asteroid);
                }
            }
        }
        int[] ret = new int[stack.size()];
        for (int i = stack.size() - 1; i >= 0; i--) {
            ret[i] = stack.pop();
        }
        return ret;
    }
}