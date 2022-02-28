// https://leetcode.com/problems/next-closest-time

class Solution1 {
    // https://www.youtube.com/watch?v=99Gw7Hezii8&lc=UgzNEpQBqLy2eWqcb4l4AaABAg&ab_channel=KevinNaughtonJr.
    // Try all minute combination and decide
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

class Solution {

    // Use TreeSet to find the next max its easier and it only does the trick in 4 tries;
    public String nextClosestTime(String time) {
        char[] chars = time.toCharArray();
        TreeSet<Character> set = new TreeSet<>(Arrays.asList(chars[0], chars[1], chars[3], chars[4]));
        
        chars[4] = getNext(chars[4], set, '9');
        if (chars[4] > time.charAt(4)) return String.valueOf(chars);
        
        chars[3] = getNext(chars[3], set, '5');
        if (chars[3] > time.charAt(3)) return String.valueOf(chars);
        
        chars[1] = getNext(chars[1], set, chars[0] < '2' ? '9' : '3');
        if (chars[1] > time.charAt(1)) return String.valueOf(chars);
        
        chars[0] = getNext(chars[0], set, '2');
        return String.valueOf(chars);
    }
    
    private char getNext(char curr, TreeSet<Character> set, char max) {
        Character next = set.higher(curr);
        if (next == null || next > max) return set.first();
        return next;
    }
}