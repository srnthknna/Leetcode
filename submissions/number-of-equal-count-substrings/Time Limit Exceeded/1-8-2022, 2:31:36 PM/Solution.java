// https://leetcode.com/problems/number-of-equal-count-substrings

class Solution {
    public int equalCountSubstrings(String s, int count) {
        int n = s.length(), ans = 0;
        
        for (int i = 0; i < n; i++) {
            Map<Character, Integer> map = new HashMap<>();
            for (int j = i; j < n; j++) {
                char curr = s.charAt(j);
                map.put(curr, map.getOrDefault(curr, 0) + 1);
                boolean isValid = true;
                if (map.get(curr) == count) {
                    for (int val: map.values()) {
                        if (val != count) {
                            isValid = false;
                        }

                    }
                } else {
                    isValid = false;
                }
                if (isValid) {
                    ans++;
                }
            }
        }
        return ans;
    }
}