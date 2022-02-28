// https://leetcode.com/problems/sort-characters-by-frequency

class Solution {
    public String frequencySort(String s) {
        Map<Character, Integer> counts = new HashMap<>();
        for (char c : s.toCharArray()) {
            counts.put(c, counts.getOrDefault(c, 0) + 1);
        }
        
        List<Character> chars = new ArrayList<>(counts.keySet());
        Collections.sort(chars, (char1, char2) -> counts.get(char2) - counts.get(char1));
        
        StringBuilder sb = new StringBuilder();
        for (char c : chars) {
            int copies = counts.get(c);
            for (int i = 0; i < copies; i++) {
                sb.append(c);
            }
        }
        return sb.toString();
    }
}