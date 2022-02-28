// https://leetcode.com/problems/two-out-of-three

class Solution {
    public List<Integer> twoOutOfThree(int[] nums1, int[] nums2, int[] nums3) {
        int count[][] = new int[3][101];
        for (int nums : nums1) {
            count[0][nums] = 1;
        }
        for (int nums : nums2) {
            count[1][nums] = 1;
        }
        for (int nums : nums3) {
            count[2][nums] = 1;
        }
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < 101; i++)
            if (count[0][i] + count[1][i] + count[2][i] > 1)
                result.add(i);
        return result;
    }
}