// https://leetcode.com/problems/height-checker

class Solution {
    public int heightChecker(int[] heights) {
        List<Integer> test = new ArrayList<>();
        for (int i = 0; i < heights.length; i++) {
            test.add(heights[i]);
        }
        Collections.sort(test);
        
        int count = 0;
        for (int i = 0; i < heights.length; i++) {
            if (heights[i] != test.get(i)) count++;
        }
        return count;
    }
}