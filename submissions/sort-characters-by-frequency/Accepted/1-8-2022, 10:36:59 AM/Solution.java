// https://leetcode.com/problems/sort-characters-by-frequency

class Solution {
    public String frequencySort(String s) {
        Map<Character, Integer> counts = new HashMap<>();
        for (char c : s.toCharArray()) {
            counts.put(c, counts.getOrDefault(c, 0) + 1);
        }
        
//         List<Character> chars = new ArrayList<>(counts.keySet());
//         Collections.sort(chars, (char1, char2) -> counts.get(char2) - counts.get(char1));
        
//         StringBuilder sb = new StringBuilder();
//         for (char c : chars) {
//             int copies = counts.get(c);
//             for (int i = 0; i < copies; i++) {
//                 sb.append(c);
//             }
//         }
//         return sb.toString();
        
        // But here instead of sorting lets try bucketing
        int maxFrequency = Collections.max(counts.values());
        List<List<Character>> bucketChars = new ArrayList<>();
        for (int i = 0; i < maxFrequency; i++) {
            bucketChars.add(new ArrayList<>());
        }
        
        for (char c : counts.keySet()) {
            bucketChars.get(counts.get(c) - 1).add(c);
        }
        
        StringBuilder sb = new StringBuilder();
        for (int freq = maxFrequency - 1; freq >= 0; freq--) {
            for (char c : bucketChars.get(freq)) {
                for (int i = 0; i < freq + 1; i++) {
                    sb.append(c);
                }
            }
        }
        return sb.toString();
    }
}