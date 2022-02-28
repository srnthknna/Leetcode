// https://leetcode.com/problems/word-ladder

class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Queue<String> queue = new LinkedList<>();
        Set<String> words = new HashSet<>(wordList);
        int level = 0;
        
        words.remove(beginWord);
        queue.add(beginWord);
        while (!queue.isEmpty()) {
            int size = queue.size();
            level++;
            for (int i = 0; i < size; i++) {
                String currWord = queue.poll();
                if (currWord.equals(endWord)) return level;
                List<String> neighs = neighbhors(currWord);
                for (String neigh : neighs) {
                    if (words.contains(neigh)) {
                        queue.add(neigh);
                        words.remove(neigh);
                    }
                }
            }
        }
        return 0;
    }
    
    private List<String> neighbhors(String currWord) {
        char[] chars = currWord.toCharArray();
        List<String> output = new ArrayList<>();
        for (int i = 0; i < chars.length; i++) {
            char temp = chars[i];
            for (char c = 'a'; c <= 'z'; c++) {
                chars[i] = c;
                output.add(new String(chars));
            }
            chars[i] = temp;
        }
        return output;
    }
}