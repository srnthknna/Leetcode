// https://leetcode.com/problems/how-many-numbers-are-smaller-than-the-current-number

class Solution {
    public int[] smallerNumbersThanCurrent(int[] nums) {
        int[] res = new int[nums.length];
        List<Integer> sorted = new ArrayList<Integer>();
        
        for (int num : nums) {
            sorted.add(num);
        }
        Collections.sort(sorted);
         
        for (int i = 0; i < nums.length; i++) {
            res[i] = sorted.indexOf(nums[i]);
        }
        return res;
    }
}