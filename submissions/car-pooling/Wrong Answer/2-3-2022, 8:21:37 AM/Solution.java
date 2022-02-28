// https://leetcode.com/problems/car-pooling

class Solution {
    //https://www.youtube.com/watch?v=nO95uYKB-lo&list=PL-Jc9J83PIiE-TR27GB7V5TBLQRT5RnSl&index=74&ab_channel=Pepcoding
    public boolean carPooling(int[][] trips, int capacity) {
        int lastDrop = -1;
        for (int[] trip : trips) {
            lastDrop = Math.max(lastDrop, trip[1]);
        }
        int[] highway = new int[lastDrop + 1];
        
        for (int[] trip: trips) {
            highway[trip[0]] += trip[2];
            highway[trip[1]] -= trip[2];
        }
        
        for (int i = 1; i <= lastDrop; i++) {
            if (highway[i] > capacity) return false;
        }
        return true;
    }
}