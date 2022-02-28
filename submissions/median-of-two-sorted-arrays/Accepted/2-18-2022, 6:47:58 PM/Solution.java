// https://leetcode.com/problems/median-of-two-sorted-arrays

import java.lang.IllegalArgumentException;

//https://github.com/mission-peace/interview/blob/master/src/com/interview/binarysearch/MedianOfTwoSortedArrayOfDifferentLength.java
//https://www.youtube.com/watch?v=LPFhl65R7ww&t=1053s&ab_channel=TusharRoy-CodingMadeSimple
class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if (nums1.length > nums2.length) {
            return findMedianSortedArrays(nums2, nums1);
        }       
        
        int x = nums1.length, y = nums2.length;
        int low = 0, high = x;
        
        while (low <= high) {
            int partisionX = (low + high) / 2;
            int partisionY = (x + y + 1) / 2 - partisionX;
            
            int maxLeftX = (partisionX == 0) ? Integer.MIN_VALUE : nums1[partisionX - 1];
            int minRightX = (partisionX == x) ? Integer.MAX_VALUE : nums1[partisionX];
            int maxLeftY = (partisionY == 0) ? Integer.MIN_VALUE : nums2[partisionY - 1];
            int minRightY = (partisionY == y) ? Integer.MAX_VALUE : nums2[partisionY];
            
            if (maxLeftX <= minRightY && maxLeftY <= minRightX) {
                if ((x + y) % 2 == 0) {
                    return (double)(Math.max(maxLeftX, maxLeftY) + Math.min(minRightX, minRightY)) / 2;
                } else {
                    return (double)Math.max(maxLeftX, maxLeftY);
                }
            } else if (maxLeftX > minRightY) {
                high = partisionX - 1;
            } else {
                low = partisionX + 1;
            }
        }
        throw new IllegalArgumentException();
    }
}