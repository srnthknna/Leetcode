// https://leetcode.com/problems/bulls-and-cows

class Solution {
    public String getHint(String secret, String guess) {
        int cow = 0, bull = 0;
        int len = secret.length();
        Map<Character, Integer> counts = new HashMap<>();
        
        for (int i = 0; i < len; i++) {
            char s = secret.charAt(i);
            char g = guess.charAt(i);
            
            if (s == g) bull++;
            else {
                if (counts.getOrDefault(s, 0) < 0) cow++;
                if (counts.getOrDefault(g, 0) > 0) cow++;
                counts.put(s, counts.getOrDefault(s, 0) + 1);
                counts.put(g, counts.getOrDefault(g, 0) - 1);
            }
        }
        return bull + "A" + cow + "B";
    }
}