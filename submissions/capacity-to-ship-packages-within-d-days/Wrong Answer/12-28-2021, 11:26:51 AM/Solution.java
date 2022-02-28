// https://leetcode.com/problems/capacity-to-ship-packages-within-d-days

class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int left = Integer.MIN_VALUE, right = 0;
        for (int w : weights) {
            left = Math.max(w, left);
            right += w;
        }
        
        while (left <= right) {
            int mid = (left) +  (right - left) / 2;
            int daysCurr = 1, curr = 0;
            for (int w : weights) {
                if (curr + w > mid) {
                    daysCurr++;
                    curr = 0;
                }
                curr += w;
            }
            
            if (daysCurr < days) right = mid - 1;
            else if (daysCurr > days) left = mid + 1;
            else return mid;
        }
        return left;
    }
}