// https://leetcode.com/problems/reorganize-string

class Solution {
    public String reorganizeString(String s) {
        int[] hash = new int[26];
        for (char c : s.toCharArray()) {
            hash[c - 'a']++;
        }
        
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> hash[b] - hash[a]);
        
        for (int i = 0; i < 26; i++) {
            if (hash[i] > (s.length() + 1) / 2) return "";
            if (hash[i] > 0)
                pq.offer(i);
        }
        
        StringBuilder sb = new StringBuilder();
        
        while (pq.size() >= 2) {
            int i = pq.poll();
            int j = pq.poll();
            sb.append((char) (i + 'a'));
            sb.append((char) (j + 'a'));
            if (--hash[i] > 0) pq.offer(i);
            if (--hash[j] > 0) pq.offer(j);
        }
        
        if (pq.size() != 0)
            sb.append((char) (pq.poll() + 'a'));
        
        return sb.toString();
    }
}