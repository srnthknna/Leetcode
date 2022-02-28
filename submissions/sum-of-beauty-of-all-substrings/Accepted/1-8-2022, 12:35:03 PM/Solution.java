// https://leetcode.com/problems/sum-of-beauty-of-all-substrings

class Solution {
    public int beautySum(String s) {
        int ans = 0, n = s.length();
        for (int i = 0; i < n; i++) {
            Map<Character, Integer> map = new HashMap<>();

            for (int j = i; j < n; j++) {
                char curr = s.charAt(j);
                int curr_freq = 0;

                if (map.containsKey(curr)) {
                    curr_freq = map.get(curr);
                }

                map.put(curr, curr_freq + 1);
                    
                int max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;
                for (int val : map.values()) {
                    max = Math.max(max, val);
                    min = Math.min(min, val);
                }
                
                ans += max - min;
            }
        }
        return ans;
    }
}