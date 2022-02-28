// https://leetcode.com/problems/largest-multiple-of-three

class Solution {
    //https://www.youtube.com/watch?v=3GsK-H_dI9o&list=PL-Jc9J83PIiE-TR27GB7V5TBLQRT5RnSl&index=64&ab_channel=Pepcoding
    // https://leetcode.com/problems/largest-multiple-of-three/discuss/518830/C%2B%2BJava-Concise-O(n)
    
    /**
    Idea is sum the array, reason is multiple of 3 should be sum divisible by 3
    if sum divisible by 3 then return the digits in reverse order avoid sorting
    If sum remainder is 1 -> remove either once 1, 4, 7 or twice 2, 5, 8
    If sum remainder is 2 -> remove either once 2, 5, 8 or twice 1, 4, 7
    the 2 list is put in the array below to make the removal easier
    **/
    public String largestMultipleOfThree(int[] digits) {
        int[] m1 = {1, 4, 7, 2, 5, 8}, m2 = {2, 5, 8, 1, 4, 7}, d = new int[10];
        int sum = 0;
        for (int digit : digits) {
            sum += digit;
            d[digit]++;
        }
        
        while (sum % 3 != 0) {
            for (int i : sum % 3 == 1 ? m1 : m2) {
                if (d[i] > 0) {
                    sum -= i;
                    --d[i];
                    break;
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 9; i >= 0; i--) {
            sb.append(Character.toString('0' + i).repeat(d[i]));  
        }
        return sb.length() > 0 && sb.charAt(0) == '0' ? "0" : sb.toString();
    }
}