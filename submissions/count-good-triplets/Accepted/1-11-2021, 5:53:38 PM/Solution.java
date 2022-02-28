// https://leetcode.com/problems/count-good-triplets

class Solution {
    public int countGoodTriplets(int[] arr, int a, int b, int c) {
        int res = 0;
        for (int i = 0; i < arr.length - 2; i++) {
            for (int j = i + 1; j < arr.length - 1; j++) {
                for (int k =  j + 1; k < arr.length; k++) {
                    if (isGood(arr[i], arr[j], arr[k], a, b,c)) res++;
                }
            }
        }
        return res;
    }
    
    private boolean isGood(int ai, int aj, int ak, int a, int b, int c) {
        return (Math.abs(ai - aj) <= a &&
           Math.abs(aj - ak) <= b &&
           Math.abs(ai - ak) <= c);
    }
}