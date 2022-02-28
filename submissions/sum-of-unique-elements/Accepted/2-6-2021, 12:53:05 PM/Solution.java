// https://leetcode.com/problems/sum-of-unique-elements

class Solution {
    public int sumOfUnique(int[] nums) {
        int[] counts = new int[101];
        for (int num : nums) counts[num]++;
        int sum = 0;
        for (int i = 1; i <= 100; i++)
            if (counts[i] == 1) sum += i;
        return sum;
    }
}