// https://leetcode.com/problems/longest-consecutive-sequence

class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        
        for (int num : nums) 
            set.add(num);
        
        int longestStreak = 0;
        for (int num : nums) {
            if (!set.contains(num - 1)) {
                int currentNum = num;
                int currentStreak = 1;
                while (set.remove(currentNum + 1)) {
                    currentNum++;
                    currentStreak++;
                }
                longestStreak = Math.max(currentStreak, longestStreak);
            }
        }
        return longestStreak;
    }
}