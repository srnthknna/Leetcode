// https://leetcode.com/problems/find-all-duplicates-in-an-array

class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> ans = new LinkedList<>();
        
        for (int num: nums) {
            if (nums[Math.abs(num) -1] < 0) 
                ans.add(Math.abs(num));
            nums[Math.abs(num) - 1] *= -1;
        }
        return ans;
    }
}