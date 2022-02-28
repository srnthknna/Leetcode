// https://leetcode.com/problems/reduction-operations-to-make-the-array-elements-equal

class Solution {
    public int reductionOperations(int[] nums) {
        int result = 0;
        
        while (!areEquals(nums)) {
            //printVals(nums);
            result += findAndUpdateSecondLargestWithMax(nums);
        }
        
        return result;
    }
    
    private void printVals(int[] nums) {
        List<Integer> numList = new ArrayList<>();
        for (int num : nums)
            numList.add(num);
        System.out.println(numList);
    }
    
    private int findAndUpdateSecondLargestWithMax(int[] nums) {
        int max = Integer.MIN_VALUE;
        int secondMax = Integer.MIN_VALUE;
        List<Integer> maxIndices = new ArrayList<>();
        
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > max) {
                secondMax = max;
                max = nums[i];
                maxIndices.clear();
                maxIndices.add(i);
            } else if (nums[i] == max) {
                maxIndices.add(i);
            } else if (nums[i] < max && nums[i] > secondMax) {
                secondMax = nums[i];
            }
        }
        for (int index : maxIndices) {
            nums[index] = secondMax;
        }
        return maxIndices.size();
    }
    
    private boolean areEquals(int[] nums) {
        if (nums.length == 1) return true;
        int first = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != first)
                return false;
        }
        return true;
    }
}