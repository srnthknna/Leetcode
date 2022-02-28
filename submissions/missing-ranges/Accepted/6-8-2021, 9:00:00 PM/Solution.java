// https://leetcode.com/problems/missing-ranges

class Solution {
    public List<String> findMissingRanges(int[] nums, int lower, int upper) {
        List<String> answer = new ArrayList<>();
        int index = 0;
        boolean previousPresent = false;
        Integer previous = null;
        if (nums.length == 0) {
            if (lower == upper)
                answer.add(lower + "");
            else
                answer.add(lower + "->" + upper);
            return answer;
        }
        int i;
        for (i = lower; i <= upper && index < nums.length; i++) {
            if (i == nums[index]) {
                index++;
            } else if (i < nums[index]) {
                if (i + 1 == nums[index]) {
                    System.out.println(i);
                    answer.add(i + "");
                } else {
                    //System.out.println(i);
                    answer.add(i + "->" + (nums[index] - 1));
                    i += nums[index] - i;
                    //System.out.println(i + " " + nums[index] + " " + index);
                    index++;
                }
            }
        }
        if (i < upper && i != upper) {
            answer.add(i + "->" + upper);
        } else if (i == upper) {
            answer.add(upper + "");
        }
        return answer;
    }
}