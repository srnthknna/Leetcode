// https://leetcode.com/problems/increasing-triplet-subsequence

class Solution {
    public boolean increasingTriplet(int[] nums) {
        List<Integer> sub = new ArrayList<>();
        sub.add(nums[0]);
        
        for (int i = 1; i < nums.length; i++) {
            int num = nums[i];
            if (num > sub.get(sub.size() - 1)) {
                sub.add(num);
            } else {
                int j = Collections.binarySearch(sub, num);
                if (j < 0) {
                    j = -(j + 1);
                }
                sub.set(j, num);
            }
        }
        return sub.size() >= 3;
    }
}