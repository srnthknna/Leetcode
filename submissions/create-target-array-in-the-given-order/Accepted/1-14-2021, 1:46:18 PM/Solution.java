// https://leetcode.com/problems/create-target-array-in-the-given-order

class Solution {
    public int[] createTargetArray(int[] nums, int[] index) {
        List<Integer> result = new ArrayList<>();
        int[] arr = new int[nums.length];
        
        for (int i = 0; i < nums.length; i++) result.add(index[i], nums[i]);
        for (int i = 0; i < nums.length; i++) arr[i] = result.get(i);
        
        return arr;
    }
}