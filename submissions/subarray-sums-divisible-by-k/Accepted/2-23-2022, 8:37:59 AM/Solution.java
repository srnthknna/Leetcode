// https://leetcode.com/problems/subarray-sums-divisible-by-k

class Solution {
    public int subarraysDivByK(int[] nums, int k) {
        int count = 0, rem = 0, sum = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            rem = sum % k;
            
            if (rem < 0)
                rem += k;
            
            int getVal = 0;
            if (map.containsKey(rem)) {
                getVal = map.get(rem);
                count += map.get(rem);
            }
            map.put(rem, getVal + 1);
        } 
        return count;
    }
}