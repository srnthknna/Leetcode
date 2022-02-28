// https://leetcode.com/problems/missing-ranges

class Solution {
    public List<String> findMissingRanges(int[] nums, int lower, int upper) {
        List<String> answer = new ArrayList<>();
        int index = 0;
        boolean previousPresent = false;
        Integer previous = null;
        if (nums.length == 0) {
            if (lower == upper)
                answer.add(new StringBuilder().append(lower).toString());
            else
                answer.add(new StringBuilder().append(lower).append("->").append(upper).toString());
            return answer;
        }
        int i;
        for (i = lower; i <= upper && index < nums.length; i++) {
            if (i == nums[index]) {
                index++;
            } else if (i < nums[index]) {
                if (i + 1 == nums[index]) {
                    answer.add(new StringBuilder().append(i).toString());
                } else {
                    answer.add(new StringBuilder().append(i).append("->").append((nums[index] - 1)).toString());
                    i += nums[index] - i;
                    index++;
                }
            }
        }
        if (i < upper && i != upper) {
            answer.add(i + "->" + upper);
            answer.add(new StringBuilder().append(i).append("->").append(upper).toString());
        } else if (i == upper) {
            answer.add(new StringBuilder().append(upper).toString());
        }
        return answer;
    }
}