// https://leetcode.com/problems/design-add-and-search-words-data-structure

class WordDictionary {
    class TrieNode {
        Map<Character, TrieNode> childs;
        boolean isEnd;
        
        public TrieNode() {
            childs = new HashMap<>();
            isEnd = false;
        }
    }
    
    private TrieNode root;
    
    /** Initialize your data structure here. */
    public WordDictionary() {
        root = new TrieNode();    
    }
    
    public void addWord(String word) {
        TrieNode current = root;
        for (char ch : word.toCharArray()) {
            TrieNode node = current.childs.get(ch);
            if (node == null) {
                node = new TrieNode();
                current.childs.put(ch, node);
            }
            current = node;
        }
        current.isEnd = true;
    }
    
    public boolean search(String word) {
        return search(root, word);
    }
    
    private boolean search(TrieNode root, String word) {
        TrieNode current = root;
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            
            TrieNode node = current.childs.get(ch);
            if (node == null) {
                if (ch == '.') {
                    for (TrieNode possibility : current.childs.values())
                    if (search(possibility, word.substring(i+1, word.length())))
                        return true;
                }
                return false;
            } else
                current = node;
        }
        return current.isEnd;
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */