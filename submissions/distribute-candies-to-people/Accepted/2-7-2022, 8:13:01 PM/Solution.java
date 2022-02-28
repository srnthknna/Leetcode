// https://leetcode.com/problems/distribute-candies-to-people

class Solution {
    public int[] distributeCandies(int candies, int num_people) {
        int[] output = new int[num_people];
        for (int i = 0; candies > 0; i++) {
            output[i % num_people] += Math.min(i + 1, candies);
            candies -= i + 1;
        }
        return output;
    }
}