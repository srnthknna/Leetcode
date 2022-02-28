// https://leetcode.com/problems/shuffle-an-array

class Solution {
    
    int[] original;
    int[] array;
    
    Random rand;

    public Solution(int[] nums) {
        array = nums;
        original = nums.clone();
        rand = new Random();
    }
    
    private int randomRange(int min, int max) {
        return rand.nextInt(max - min) + min;
    }
    
    private void swap(int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
    
    public int[] reset() {
        array = original;
        original = original.clone();
        return original;
    }
    
    public int[] shuffle() {
        for (int i = 0; i < array.length; i++)
            swap(i, randomRange(i, array.length));
        return array;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int[] param_1 = obj.reset();
 * int[] param_2 = obj.shuffle();
 */