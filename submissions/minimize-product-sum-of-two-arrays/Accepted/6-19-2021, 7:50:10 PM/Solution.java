// https://leetcode.com/problems/minimize-product-sum-of-two-arrays

class Solution {
    public int minProductSum(int[] nums1, int[] nums2) {
        int[] count = new int[101];
        Arrays.sort(nums1);
        
        for (int num : nums2) {
            count[num]++;
        }
        
        int j = 0;
        int res = 0;
        
        for (int i = 100; i >=0; i--) {
            while (count[i] > 0) {
                res += i * nums1[j];
                count[i]--;
                j++;
            }
        }
        return res;
    }
}