// https://leetcode.com/problems/maximal-rectangle

class Solution {
    private int maxAreaHistogram(int[] heights) {
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        int maxArea = 0;
        
        for (int i = 0; i < heights.length; i++) {
            while (stack.peek() != -1 && heights[stack.peek()] > heights[i]) {
                int currentHeight = heights[stack.pop()];
                int currentWidth = i - stack.peek() - 1;
                maxArea = Math.max(maxArea, currentHeight * currentWidth);
            }
            stack.push(i);
        }
        while (stack.peek() != -1) {
            int currentHeight = heights[stack.pop()];
            int currentWidth = heights.length - stack.peek() - 1;
            maxArea = Math.max(maxArea, currentHeight * currentWidth);
        }
        return maxArea;
    }
    
    public int maximalRectangle(char[][] matrix) {
        if (matrix.length == 0) return 0;
        
        int[] dp = new int[matrix[0].length];
        int maxArea = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                dp[j] = matrix[i][j] == '1' ? dp[j] + 1 : 0;
            }
            maxArea = Math.max(maxArea, maxAreaHistogram(dp));
        }
        return maxArea;
    }
}