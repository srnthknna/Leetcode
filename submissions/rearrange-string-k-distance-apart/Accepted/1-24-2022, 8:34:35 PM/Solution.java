// https://leetcode.com/problems/rearrange-string-k-distance-apart

class Solution {
    public String rearrangeString(String s, int k) {
        if (s.length() <= 1 || k <= 1) return s;
        int[] hash = new int[26];
        
        for (char c : s.toCharArray()) {
            hash[c - 'a']++;
        }
        
        PriorityQueue<Integer> pq = new PriorityQueue<>(
            (a, b) -> ((hash[b] == hash[a]) ? (b - a) : (hash[b] - hash[a]))
            );
        StringBuilder sb = new StringBuilder();
        
        for (int i = 0; i < 26; i++) {
            if (hash[i] > 0)
                pq.offer(i);
        }
        
        while (pq.size() >= k) {
            List<Integer> charList = new ArrayList<>();
            for (int i = 0; i < k; i++) {
                charList.add(pq.poll());
            }
            
            for (int charVal : charList) {
                sb.append((char) (charVal + 'a'));
                if (--hash[charVal] > 0) pq.offer(charVal);
            }
        }
        
        while (!pq.isEmpty()) {
            int charVal = pq.poll();
            if (--hash[charVal] > 0) return "";
            sb.append((char) (charVal + 'a'));
        }
        return sb.toString();
    }
}