// https://leetcode.com/problems/sort-transformed-array

// Yes the generic way is to update the array with new values and sorting it
// its O(n) to find new values and O(nlogn) to sort them lets try that first
class Solution1 {
    public int[] sortTransformedArray(int[] nums, int a, int b, int c) {
        for (int i = 0; i < nums.length; i++) {
            nums[i] = nums[i] * nums[i] * a + b * nums[i] + c;
        }
        Arrays.sort(nums);
        return nums;
    }
}

// Next will be to use TreeSet to store the values in the sorted order
// TreeSet will not work if there are duplicates;
class Solution2 {
    public int[] sortTransformedArray(int[] nums, int a, int b, int c) {
        TreeSet<Integer> vals = new TreeSet<>();
        for (int i = 0; i < nums.length; i++) {
            System.out.println(nums[i] * nums[i] * a + b * nums[i] + c);
            vals.add(nums[i] * nums[i] * a + b * nums[i] + c);
        }
        int i = 0;
        int[] result = new int[nums.length];
        for (int val : vals) {
            result[i++] = val;
        }
        return result;
    }
}

// Two pointer
class Solution {
    public int[] sortTransformedArray(int[] nums, int a, int b, int c) {
        int n = nums.length, i = a > 0 ? n - 1 : 0;
        int[] result = new int[nums.length];

        int left = 0, right = n - 1;
        while (left <= right) {
            int leftVal = (nums[left] * nums[left] * a + b * nums[left] + c);
            int rightVal = (nums[right] * nums[right] * a + b * nums[right] + c);
                
            if (a <= 0) {
                if (leftVal < rightVal) {
                    result[i++] = leftVal;
                    left++;
                } else {
                    result[i++] = rightVal;
                    right--;
                }
            } else {
                if (leftVal < rightVal) {
                    result[i--] = rightVal;
                    right--;
                } else {
                    result[i--] = leftVal;
                    left++;
                } 
            }
        }
        
        return result;
    }
}