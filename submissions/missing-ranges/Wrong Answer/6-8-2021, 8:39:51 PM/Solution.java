// https://leetcode.com/problems/missing-ranges

class Solution {
    public List<String> findMissingRanges(int[] nums, int lower, int upper) {
        LinkedList<String> answer = new LinkedList<>();
        int index = 0;
        boolean previousPresent = false;
        Integer previous = null;
        for (int i = lower; i <= upper; i++) {
            if (i == nums[index]) {
                index++;
            } else if (i < nums[index]) {
                if (i + 1 == nums[index]) {
                    answer.add(i + "");
                } else {
                    answer.add(i + "->" + (nums[index] - 1));
                    i += nums[index] - 1;
                    index++;
                }
            }
        }
        return answer;
    }
}