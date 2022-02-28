// https://leetcode.com/problems/set-intersection-size-at-least-two

class Solution {
    public int intersectionSizeTwo(int[][] intervals) {
            
        Arrays.sort(intervals, (a,b)->(a[1]-b[1]));

        int[] cur = new int[2];
        int res = 0;
        for (int[] interval : intervals) {
            int start = interval[0], end = interval[1];
            if (start > cur[1]) {
                res += 2;
                cur[0] = end - 1; 
                cur[1] = end; 
            } else if (start == cur[1] || start > cur[0]) {
                res += 1;
                cur[0] = cur[1];
                cur[1] = end;  
            }
        }
        return res;

    }
}