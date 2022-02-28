// https://leetcode.com/problems/alien-dictionary

class Solution {
    public String alienOrder(String[] words) {
        Map<Character, Integer> counts = new HashMap<>();
        Map<Character, List<Character>> graph = new HashMap<>();
        
        for (String word : words) {
            for (char c : word.toCharArray()) {
                graph.put(c, new ArrayList<Character>());
                counts.put(c, 0);
            }
        }
        
        for (int i = 1; i < words.length; i++) {
            String first = words[i - 1], second = words[i];
            
            int len = Math.min(first.length(), second.length());
            if (first.length() > second.length() && first.startsWith(second)) return "";
            
            for (int j = 0; j < len; j++) {
                if (first.charAt(j) != second.charAt(j)) {
                    char out = first.charAt(j), in = second.charAt(j);
                    graph.get(out).add(in);
                    counts.put(in, counts.get(in) + 1);
                    break;
                }
            }
        }
        
        StringBuilder sb = new StringBuilder();
        Queue<Character> queue = new LinkedList<>();
        
        for (char c : counts.keySet()) {
            if (counts.get(c) == 0) {
                queue.offer(c);
            }
        }
        
        while (!queue.isEmpty()) {
            char curr = queue.poll();
            sb.append(curr);
            
            for (char neigh : graph.get(curr)) {
                counts.put(neigh, counts.get(neigh) - 1);
                if (counts.get(neigh) == 0) {
                    queue.offer(neigh);
                }
            }
        }
        System.out.println(sb.toString());
        
        return sb.length() == counts.size() ? sb.toString() : "";
    }
}