// https://leetcode.com/problems/random-pick-index

class Solution {
    
    Map<Integer, List<Integer>> indices;
    Random rand;

    public Solution(int[] nums) {
        indices = new HashMap<>();
        rand = new Random();
        for (int i = 0; i < nums.length; i++) {
            if (!indices.containsKey(nums[i]))
                indices.put(nums[i], new ArrayList<>());
            indices.get(nums[i]).add(i);
        }
    }
    
    public int pick(int target) {
        return indices.get(target).get(rand.nextInt(indices.get(target).size()));
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int param_1 = obj.pick(target);
 */