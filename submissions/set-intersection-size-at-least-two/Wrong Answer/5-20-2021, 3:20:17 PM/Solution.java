// https://leetcode.com/problems/set-intersection-size-at-least-two

class Solution {
    public int intersectionSizeTwo(int[][] intervals) {
        //if (intervals.length == 1) return 2;
            
        Arrays.sort(intervals, Comparator.comparingDouble(o -> o[1]));

        int[] cur = new int[2];
        int res = 0;
        for (int[] interval : intervals) {
            int start = interval[0], end = interval[1];
            //System.out.println("begin " + cur[0] + " " + cur[1]);
            if (start < cur[1]) continue;
            else if (start > cur[1]) {
                res += 2;
                cur[0] = end - 1; 
                cur[1] = end; 
                //System.out.println("else if " + cur[0] + " " + cur[1]);
            } else {
                res += 1;
                cur[0] = cur[1];
                cur[1] = end;  
                //System.out.println("else " + cur[0] + " " + cur[1]);
            }
            //System.out.println(cur[0] + " " + cur[1]);
        }
        return res;
    }
}