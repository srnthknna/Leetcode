// https://leetcode.com/problems/random-pick-index

class Solution {

    int[] nums;
    Random rand;
    
    public Solution(int[] nums) {
        this.nums = nums;
        this.rand = new Random();
    }
    
    public int pick(int target) {
        List<Integer> indices = new ArrayList<>();
        int n = this.nums.length;
        
        for (int i = 0; i < n; i++) {
            if (this.nums[i] == target)
                indices.add(i);
        }
        
        return indices.get(rand.nextInt(indices.size()));
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int param_1 = obj.pick(target);
 */