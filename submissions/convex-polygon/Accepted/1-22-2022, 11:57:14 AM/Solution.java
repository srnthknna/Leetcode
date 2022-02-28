// https://leetcode.com/problems/convex-polygon

class Solution {
    public boolean isConvex(List<List<Integer>> points) {
        boolean pos = false, neg = false;
        int n = points.size();
        
        for (int i = 0; i < n; i++) {
            List<Integer> p1 = points.get(i);
            List<Integer> p2 = points.get((i + 1) % n);
            List<Integer> p3 = points.get((i + 2) % n);
            
            int angle = (p3.get(0) - p2.get(0)) * (p2.get(1) - p1.get(1)) - (p3.get(1) - p2.get(1)) * (p2.get(0) - p1.get(0));
            
            if (angle == 0) continue;
            else if (angle > 0) pos = true;
            else neg = true;
            
            if (pos && neg) return false;
        }
        return true;
    }
}