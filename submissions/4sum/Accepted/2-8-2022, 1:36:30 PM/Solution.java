// https://leetcode.com/problems/4sum

class Solution {
    //https://www.youtube.com/watch?v=4ggF3tXIAp0
    // Sort the array and then use n-2 looks plus 2 pointer to do the remaining 
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums == null || nums.length == 0)
            return result;
        Arrays.sort(nums);
        int n = nums.length;
        
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int target2 = target - nums[i] - nums[j];
                int left = j + 1;
                int right = n - 1;
                
                while (left < right) {
                    int twoSum = nums[left] + nums[right];
                    if (twoSum < target2) {
                        left++;
                    } else if (twoSum > target2) {
                        right--;
                    }
                    else {
                        List<Integer> quad = Arrays.asList(nums[i], nums[j], nums[left], nums[right]);
                        result.add(quad);
                        while (left < right && nums[left] == quad.get(2)) left++;
                        while (left < right && nums[right] == quad.get(2)) right--;
                    }
                }
                while (j + 1 < n && nums[j + 1] == nums[j]) j++;
            }
            while (i + 1 < n && nums[i + 1] == nums[i]) i++;
        }
        return result;
    }
}