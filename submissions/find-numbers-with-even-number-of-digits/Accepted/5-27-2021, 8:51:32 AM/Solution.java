// https://leetcode.com/problems/find-numbers-with-even-number-of-digits

class Solution {
    public int findNumbers(int[] nums) {
        int cnt = 0;
        for(int i : nums) {
            if (((int)(Math.log10(i))+1)%2==0) cnt++;
        }
        return cnt;
    }
}