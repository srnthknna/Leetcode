// https://leetcode.com/problems/contains-duplicate-iii

class Solution {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        if (nums.length == 0 || k <= 0) return false;
        
        TreeSet<Integer> set = new TreeSet<>();
        for (int i = 0; i < nums.length; i++) {
            Integer one = set.ceiling(nums[i]);
            
            if (one != null && (long) one <= (long) nums[i] + t) return true;
            
            Integer two = set.floor(nums[i]);
            
            if (two != null && (long) two >= (long) nums[i] - t) return true;
            
            set.add(nums[i]);
            if (set.size() > k)
                set.remove(nums[i - k]);
        }
        return false;
    }
    
    /*
    i - j <= k
    | nums[i] - nums[j] | <= t
    1) [one] nums[i] - nums[j] <= t -> nums[i] <= nums[j] + t (floor)
    2) [two] nums[i] - nums[j] >= -t -> nums[i] >= num[j] - t (ceil)
    */
}