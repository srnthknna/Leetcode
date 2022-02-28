// https://leetcode.com/problems/decompress-run-length-encoded-list

class Solution {
    public int[] decompressRLElist(int[] nums) {
        // List<Integer> res = new ArrayList<>();
        // for (int i = 0; i < nums.length; i+=2) {
        //     for (int j = 0; j < nums[i]; j++) {
        //         res.add(nums[i + 1]);
        //     }
        // }
        // int[] arr = new int[res.size()];
        // for (int i = 0; i < arr.length; i++) {
        //     arr[i] = res.get(i);
        // }
        // return arr;
        
        int size = 0;
        for (int i = 0; i < nums.length; i+=2) 
            size += nums[i];
        
        int[] res = new int[size];
        int index = 0;
        for (int i = 0; i < nums.length; i+=2) {
            for (int j = 0; j < nums[i]; j++) {
                res[index++] = nums[i + 1];
            }
        }
        
        return res;
    }
}