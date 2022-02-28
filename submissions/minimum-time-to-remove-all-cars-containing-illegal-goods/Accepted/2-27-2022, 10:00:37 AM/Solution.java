// https://leetcode.com/problems/minimum-time-to-remove-all-cars-containing-illegal-goods

// https://www.youtube.com/watch?v=QjPL6-ZX_Cs&list=PLEI-q7w3s9gTJxsvjlI4NxWXtI3-UHUff&ab_channel=CodingDecoded
// Create 2 prefix sum array one for left to right and the other for right to left
// in the left to right what we care is minimum of the cost if the car is removed from all left which translates to i + 1 or the middle removal which is left[i] + 2 only if the cart is 1 else we just use the left[i]
// in the right to left its the same what we did from left to right 
// Now that we have 2 arrays what we need to do is traverse from 0 - n and then add left and right and pick the min sum and in this case we cannot add the ith index of left and right,
// the reason being we need to minimize the ith in left and the i+1th value in right
// See solution below for no space use
class Solution1 {
    public int minimumTime(String s) {
        int n = s.length(), result = Integer.MAX_VALUE;
        int[] nums = new int[n], left = new int[n], right = new int[n];
        
        for (int i = 0; i < n; i++) {
            nums[i] = s.charAt(i) - '0';
        }
                
        left[0] = nums[0];
        for (int i = 1; i < n; i++) {
            left[i] = Math.min(i + 1, left[i - 1] + (nums[i] == 1 ? 2 : 0));
        }
                
        right[n - 1] = nums[ n - 1];
        for (int i = n - 2; i >= 0; i--) {
            right[i] = Math.min(n - i, right[i + 1] + (nums[i] == 1 ? 2 : 0));
        }
        
        for (int i = 0; i < n; i++) {
            int leftVal = left[i];
            int rightVal = i == n - 1 ? 0 : right[i + 1];
            result = Math.min(result, leftVal + rightVal);
        }
        return result;
    }
}

class Solution {
    public int minimumTime(String s) {
        int n = s.length(), result = Integer.MAX_VALUE, left = 0;

        for (int i = 0; i < n; i++) {
            left = Math.min(i + 1, left + (s.charAt(i) - '0') * 2);
            result = Math.min(result, left + n - i - 1);
        }
        return result;
    }
}