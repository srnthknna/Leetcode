// https://leetcode.com/problems/random-point-in-non-overlapping-rectangles

class Solution {

    TreeMap<Integer, Integer> map = new TreeMap<>();
    Random rnd = new Random();
    int[][] arrays;
    int area;
    
    public Solution(int[][] rects) {
        area = 0;
        arrays = rects;
        for (int i = 0; i < rects.length; i++) {
            int[] rect = rects[i];
            int x = rect[2] - rect[0];
            int  y = rect[3] - rect[1];
            area += x * y;
            map.put(area, i);
        }
    }
    
    public int[] pick() {
        int c = map.ceilingKey(rnd.nextInt(area) + 1);
        
        return pickInRect(arrays[map.get(c)]);
    }
    
    private int[] pickInRect(int[] rect) {
        int left = rect[0], right = rect[2], bot = rect[1], top = rect[3];
        
        return new int[]{left + rnd.nextInt(right - left + 1), bot + rnd.nextInt(top - bot + 1) };
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(rects);
 * int[] param_1 = obj.pick();
 */