// https://leetcode.com/problems/koko-eating-bananas

class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int left = 1, right = 1;
        for (int pile : piles) {
            right = Math.max(right, pile);
        }
        
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (caneat(piles, mid, h)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }
    
    private boolean caneat(int[] piles, int k, int h) {
        // we need to add and subtract 1 to make sure we count less than k pile as 1
        for (int pile : piles) {
            h -= 1 + (pile - 1) / k;
        }
        return h >= 0;
    }
    
}