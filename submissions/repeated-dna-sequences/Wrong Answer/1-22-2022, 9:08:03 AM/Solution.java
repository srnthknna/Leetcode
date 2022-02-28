// https://leetcode.com/problems/repeated-dna-sequences

class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        Map<String, Integer> sequencesCount = new HashMap<>();
        List<String> result = new ArrayList<>();
        
        for (int i = 0; i < s.length() - 10; i++) {
            String curr = s.substring(i, i + 10);
            int currCount = 0;
            if (sequencesCount.containsKey(curr)) {
                currCount = sequencesCount.get(curr);
                if (currCount == 1) {
                    result.add(curr);
                }
            }
            sequencesCount.put(curr, currCount + 1);
        }
        return result;
    }
}