// https://leetcode.com/problems/longest-consecutive-sequence

class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        
        for (int num : nums) 
            set.add(num);
        
        int longestStreak = 0, currentNum = 0, currentStreak = 0;
        for (int num : nums) {
            if (!set.contains(num - 1)) {
                currentNum = num;
                currentStreak = 1;
                while (set.contains(currentNum + 1)) {
                    currentNum++;
                    currentStreak++;
                }
            }
            longestStreak = Math.max(currentStreak, longestStreak);
        }
        return longestStreak;
    }
}