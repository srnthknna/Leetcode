// https://leetcode.com/problems/minimum-time-difference

class Solution {
    public int findMinDifference(List<String> timePoints) {
        Integer firstTime = null, prevTime = null;
        int diff = Integer.MAX_VALUE;
        boolean[] times = new boolean[1440];
        
        for (String time : timePoints) {
            String[] split = time.split(":");
            int hour = Integer.parseInt(split[0]);
            int min = Integer.parseInt(split[1]);
            int calc = hour * 60 + min;
            if (times[hour * 60 + min]) return 0;
            times[calc] = true;
        }
        
        for (int i = 0; i < 1440; i++) {
            if (times[i]) {
                if (firstTime == null) {
                    firstTime = i;
                    prevTime = i;
                } else {
                    diff = Math.min(diff, Math.min(i - prevTime, 1440 - i + prevTime));
                    prevTime = i;
                }
            }
        }
        diff = Math.min(diff, Math.min(prevTime - firstTime, 1440 - prevTime + firstTime));
        return diff;
    }
}