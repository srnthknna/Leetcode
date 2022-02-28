// https://leetcode.com/problems/set-intersection-size-at-least-two

class Solution {
    public int intersectionSizeTwo(int[][] intervals) {
        if (intervals.length == 1) return 2;
            
        Arrays.sort(intervals, Comparator.comparingDouble(o -> o[1]));

        int[] cur = new int[2];
        int res = 0;
        for (int[] interval : intervals) {
            if (interval[0] > cur[1]) {
                res += 2;
                cur[0] = interval[1] - 1; 
                cur[1] = interval[1]; 
            } else if (interval[0] > cur[0]) {
                res ++;
                cur[0] = cur[1]; 
                cur[1] = interval[1]; 
            }
        }
        return res;
    }
//                 if not cur or start>cur[1]:
//                 res+=2
//                 cur=[end-1,end]
                
//             elif start>cur[0]:
//                 res+=1
//                 cur=[cur[1],end]
}