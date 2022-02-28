// https://leetcode.com/problems/next-closest-time

class Solution {
    public String nextClosestTime(String time) {
        Set<Integer> set = new HashSet<>();
        int[] result = new int[4];
        int i = 0;
        for (int c : time.toCharArray()) {
            if (c == ':') continue;
            result[i] = c - '0';
            set.add(result[i]);
            i++;
        }
        
        int minutes = (result[0] * 10 + result[1]) * 60 + (result[2] * 10 + result[3]);
        
        while (true) {
            minutes = ++minutes % (1440);
            
            int H = minutes / 60 / 10;
            int h = minutes / 60 % 10;
            int M = minutes % 60 / 10;
            int m = minutes % 60 % 10;
            
            if (!set.contains(H) || !set.contains(h) || !set.contains(M) || !set.contains(m)) continue;
            
            return String.format("%d%d:%d%d", H, h, M, m);
        }
    }
}