// https://leetcode.com/problems/largest-multiple-of-three

class Solution {
    public String largestMultipleOfThree(int[] digits) {
        int[] m1 = {1, 4, 6, 2, 5, 8}, m2 = {2, 5, 8, 1, 4, 7}, d = new int[10];
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