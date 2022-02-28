// https://leetcode.com/problems/trapping-rain-water

class Solution {
    public int trap(int[] height) {
        int left = 0, right = height.length - 1, trappedWater = 0;
        int maxLeft = 0, maxRight = 0;
        
        while (left < right) {
            if (height[left] < height[right]) {
                if (height[left] >= maxLeft) {
                    maxLeft = height[left];
                } else { 
                    trappedWater += maxLeft - height[left];
                }
                left++;
            } else {
                if (height[right] >= maxRight) {
                    maxRight = height[right];
                } else {
                    trappedWater += maxRight - height[right];
                }
                right--;
            }
        }
        return trappedWater;
    }
}